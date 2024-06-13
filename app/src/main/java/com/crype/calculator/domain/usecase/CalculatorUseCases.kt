package com.crype.calculator.domain.usecase

import com.crype.calculator.domain.model.CalculatorState

class CalculatorUseCases {

    private var isNewValue = false
    private var isOperationClicked = false
    private var isFirstValue: Boolean = false
    private var isSecondValue: Boolean = false
    private var firstValue: Float = 0f
    private var secondValue: Float = 0f
    private var sign: String = ""
    private var resultValue: Int = 0
    fun onDigitClick(state: CalculatorState, digit: String): CalculatorState {
        return if (isMaxLength(state.input)) state
        else if (isNewValue) {
            isOperationClicked = false
            isNewValue = false
            state.copy(input = digit)
        }
        else state.copy(input = state.input + digit)
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
        return if (state.input.isEmpty() || isOperationClicked) {
            sign = operation
            state
        }
        else if (isFirstValue){
            secondValue = state.input.toFloat()
            firstValue = expression(operation)
            sign = operation
            isNewValue = true
            isOperationClicked = true
            state.copy(result = floatToString(firstValue))
        } else {
            firstValue = state.input.toFloat()
            isFirstValue = true

            isNewValue = true
            state
        }
    }

    fun onEqualsClick(state: CalculatorState): CalculatorState {
        if (state.input.isEmpty()) return state
        else if (isFirstValue){
            secondValue = state.input.toFloat()
            firstValue = expression(sign)
        }
        else firstValue = state.input.toFloat()
        return state.copy(result = floatToString(firstValue))
    }

    fun onPlusMinusClick(state: CalculatorState): CalculatorState {
        if (isMaxLength(state.input)) return state
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
        return if (state.input.contains('.') || isMaxLength(state.input)) state
        else if (state.input.isEmpty() || isNewValue){
            isNewValue = false
            isOperationClicked = false
            state.copy(input = "0.")
        }

        else {
            isOperationClicked = false
            state.copy(input = state.input + ".")
        }

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