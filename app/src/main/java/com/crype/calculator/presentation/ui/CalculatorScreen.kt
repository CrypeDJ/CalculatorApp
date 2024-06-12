package com.crype.calculator.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crype.calculator.presentation.ui.theme.CalculatorTheme
import com.crype.calculator.presentation.ui.theme.backgroundTheme
import com.crype.calculator.presentation.ui.theme.inputColor
import com.crype.calculator.presentation.ui.theme.lineColor
import com.crype.calculator.presentation.ui.theme.resultColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorScreen()
                }
            }
        }
    }
}
@Preview
@Composable
fun CalculatorScreen() {
    var input by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(backgroundTheme),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "2+7",
            fontSize = 45.sp,
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(20.dp),
            color = inputColor
        )
        Text(
            text = "9",
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
            onInput = { char ->
                if (char == "C") {
                    input = ""
                    result = ""
                } else if (char == "=") {
                    // Here you can add your evaluation logic
                    result = input // This is a placeholder
                } else {
                    input += char
                }
            }
        )
    }
}





