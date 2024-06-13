package com.crype.calculator.domain.usecase

import com.crype.calculator.domain.model.CalculatorState

class CalculatorUseCases {
    var isNewValue = false;
    var isFirstValue: Boolean = false
    var isSecondValue: Boolean = false
    var firstValue: Float = 0f
    var secondValue: Float = 0f
    var sign: String = ""
    var resultValue: Int = 0
    fun onDigitClick(state: CalculatorState, digit: String): CalculatorState {
        return state.copy(input = state.input + digit)
    }

    fun onClear(state: CalculatorState): CalculatorState {
        return state.copy(input = "", result = "")
    }

    fun onOperationClick(state: CalculatorState, operation: String): CalculatorState {
        if (isFirstValue){

            return state
        }
        else {
            firstValue = state.input.toFloat()
            isFirstValue = true
            return state
        }

    }

    fun onEqualsClick(state: CalculatorState): CalculatorState {
        // To be implemented
        return state
    }

    fun onPlusMinusClick(state: CalculatorState): CalculatorState {
        // To be implemented
        return state
    }

    fun onPercentClick(state: CalculatorState):CalculatorState{
        return state
    }

    fun Expression (state: CalculatorState, operation: String): Float {
        when(operation){
            "+" -> return firstValue + secondValue
            "-" -> return firstValue - secondValue
            "×" -> return firstValue + secondValue
            "÷" -> return firstValue + secondValue
        }
        return 0f
    }
}