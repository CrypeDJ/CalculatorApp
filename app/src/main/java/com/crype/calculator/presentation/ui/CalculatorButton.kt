package com.crype.calculator.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.calculator.presentation.ui.theme.backgroundButton

@Composable
fun CalculatorButton(
    label: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val backgroundColor = when (label) {
        "C" -> Color.Red
        "=" -> Color.Green
        else -> backgroundButton
    }

    val textColor = when (label) {
        "C", "=" -> Color.Black
        "÷", "×", "-", "+", "%" -> Color.Green
        else -> Color.White
    }

    Box(
        modifier = modifier
            .background(backgroundColor, shape = RoundedCornerShape(8.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            fontSize = 35.sp,
            fontWeight = FontWeight.Medium,
            color = textColor
        )
    }
}