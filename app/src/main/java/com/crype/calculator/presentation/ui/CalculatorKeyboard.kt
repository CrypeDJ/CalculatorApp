package com.crype.calculator.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorKeyboard(
    onDigitClick: (String) -> Unit,
    onClear: () -> Unit,
    onOperationClick: (String) -> Unit,
    onEqualsClick: () -> Unit,
    onPlusMinusClick: () -> Unit,
    onPercentClick:() -> Unit
) {
    val buttons = listOf(
        listOf("C", "+/-", "%", "÷"),
        listOf("7", "8", "9", "×"),
        listOf("4", "5", "6", "-"),
        listOf("1", "2", "3", "+"),
        listOf("0", ".", "=")
    )

    val bottomButtons = listOf("0", ".", "=")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        buttons.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                row.forEach { label ->
                    CalculatorButton(
                        label = label,
                        modifier = Modifier
                            .weight(if (label == "=") 2f else 1f)
                            .aspectRatio(if (label == "=") 2f else 1f),
                        onClick = {
                            when (label) {
                                "C" -> onClear()
                                "=" -> onEqualsClick()
                                "+/-" -> onPlusMinusClick()
                                "÷", "×", "-", "+" -> onOperationClick(label)
                                "%" -> onPercentClick()
                                else -> onDigitClick(label)
                            }
                        }
                    )
                }
            }
        }
    }
}


