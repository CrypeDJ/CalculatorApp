package com.crype.calculator.presentation.viewmodel

import com.crype.calculator.domain.model.CalculatorState
import com.crype.calculator.domain.usecase.CalculatorUseCases
import androidx.compose.runtime.*

class CalculatorViewModel {
    private val useCases = CalculatorUseCases()
    private var _state = mutableStateOf(CalculatorState())
    val state: State<CalculatorState> get() = _state

    fun onDigitClick(digit: String) {
        _state.value = useCases.onDigitClick(_state.value, digit)
    }

    fun onClear() {
        _state.value = useCases.onClear()
    }

    fun onOperationClick(operation: String) {
        _state.value = useCases.onOperationClick(_state.value, operation)
    }

    fun onEqualsClick() {
        _state.value = useCases.onEqualsClick(_state.value)
    }

    fun onPlusMinusClick() {
        _state.value = useCases.onPlusMinusClick(_state.value)
    }
}