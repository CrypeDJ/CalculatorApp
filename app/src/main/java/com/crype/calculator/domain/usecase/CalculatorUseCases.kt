package com.crype.calculator.domain.usecase

import com.crype.calculator.domain.model.CalculatorState

class CalculatorUseCases {

    private var isNewValue = false
    private var isOperationClicked = false
    private var isFirstValue: Boolean = false
    private var firstValue: Float = 0f
    private var secondValue: Float = 0f
    private var sign: String = ""
    fun onDigitClick(state: CalculatorState, digit: String): CalculatorState {
        isOperationClicked = false

        if (isMaxLength(state.input)) return state

        val newInput = if (isNewValue) {
            isNewValue = false
            digit
        } else {
            state.input + digit
        }

        return state.copy(input = newInput)
    }

    fun onClear(state: CalculatorState): CalculatorState {
        isOperationClicked = false
        isNewValue = false
        isFirstValue = false
        sign = ""
        firstValue = 0f
        secondValue= 0f
        return state.copy(input = "", result = "")
    }

    fun onOperationClick(state: CalculatorState, operation: String): CalculatorState {
        if (state.input.isEmpty() || isOperationClicked) return state

        return if (isFirstValue) {
            secondValue = state.input.toFloat()
            firstValue = expression(operation)

            isNewValue = true
            sign = operation
            state.copy(result = floatToString(firstValue))
        } else {
            firstValue = state.input.toFloat()
            isFirstValue = true
            isOperationClicked = true
            isNewValue = true
            sign = operation
            state
        }
    }

    fun onEqualsClick(state: CalculatorState): CalculatorState {
        if (state.input.isEmpty()) return state
        firstValue = if (isFirstValue) {
            secondValue = state.input.toFloat()
            expression(sign)
        } else {
            state.input.toFloat()
        }

        isOperationClicked = true
        return state.copy(result = floatToString(firstValue))
    }

    fun onPlusMinusClick(state: CalculatorState): CalculatorState {
        var number: String
        number = if (state.input.startsWith("-")) {
            state.input.substring(1)
        } else {
            number = state.input
            "-$number"
        }
        return state.copy(input = number)

    }

    fun onPointClick (state: CalculatorState): CalculatorState {
        if (state.input.contains('.') || isMaxLength(state.input)) return state
        val newInput = when {
            state.input.isEmpty() || isNewValue -> {
                isNewValue = false
                "0."
            }
            else -> state.input + "."
        }

        isOperationClicked = false
        return state.copy(input = newInput)

    }
    fun onPercentClick(state: CalculatorState):CalculatorState{
        firstValue = state.input.toFloat()/100
        val percent = floatToString(firstValue)
        return state.copy(input = percent, result = percent)
    }

    private fun expression (operation: String): Float {
        return when(operation){
            "+" ->  firstValue + secondValue
            "-" ->  firstValue - secondValue
            "×" ->  firstValue * secondValue
            "÷" ->  firstValue / secondValue
            else -> 0f
        }
    }

    private fun floatToString(value: Float): String {
        return if (value % 1 == 0.0f) {
            value.toInt().toString()
        } else {
            value.toString()
        }
    }
    private fun isMaxLength (input: String): Boolean{
        return input.length >= 13
    }
}