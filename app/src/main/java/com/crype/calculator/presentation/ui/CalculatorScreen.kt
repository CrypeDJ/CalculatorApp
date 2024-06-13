package com.crype.calculator.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.calculator.presentation.ui.theme.backgroundTheme
import com.crype.calculator.presentation.ui.theme.inputColor
import com.crype.calculator.presentation.ui.theme.lineColor
import com.crype.calculator.presentation.ui.theme.resultColor
import com.crype.calculator.presentation.viewmodel.CalculatorViewModel

@Preview
@Composable
fun CalculatorScreen(viewModel: CalculatorViewModel = remember { CalculatorViewModel() }) {
    val state = viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(backgroundTheme),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = state.value.input,
            fontSize = 45.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(20.dp),
            color = inputColor
        )
        Text(
            text = state.value.result,
            fontSize = 45.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(20.dp),
            color = resultColor
        )
        Spacer(modifier = Modifier.height(8.dp))
        Divider(
            modifier = Modifier
                .padding(horizontal = 20.dp),
            color = lineColor,
            thickness = 1.dp

        )
        CalculatorKeyboard(
            onDigitClick = viewModel::onDigitClick,
            onClear = viewModel::onClear,
            onOperationClick = viewModel::onOperationClick,
            onEqualsClick = viewModel::onEqualsClick,
            onPlusMinusClick = viewModel::onPlusMinusClick,
            onPercentClick = viewModel::onPercentClick
        )
    }
}





