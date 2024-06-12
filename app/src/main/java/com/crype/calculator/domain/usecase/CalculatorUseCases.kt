package com.crype.calculator.domain.usecase

import com.crype.calculator.domain.model.CalculatorState

class CalculatorUseCases {
    fun onDigitClick(state: CalculatorState, digit: String): CalculatorState {
        return state.copy(input = state.input + digit)
    }

    fun onClear(): CalculatorState {
        return CalculatorState()
    }

    fun onOperationClick(state: CalculatorState, operation: String): CalculatorState {
        // To be implemented
        return state
    }

    fun onEqualsClick(state: CalculatorState): CalculatorState {
        // To be implemented
        return state
    }

    fun onPlusMinusClick(state: CalculatorState): CalculatorState {
        // To be implemented
        return state
    }
}