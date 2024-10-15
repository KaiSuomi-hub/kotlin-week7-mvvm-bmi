package com.example.viikko2_in00ct07_3007

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.viikko2_in00ct07_3007.ui.theme.Viikko2IN00CT073007Theme
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Viikko2IN00CT073007Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    BmiCalculator()
                }
            }
        }
    }
}

@Composable
fun BmiCalculator() {
    var heightInput: String by remember { mutableStateOf("") }
    var weightInput: String by remember { mutableStateOf("") }
    val height = heightInput.toFloatOrNull() ?: 0.0f
    val weight = weightInput.toFloatOrNull() ?: 0.0f

    val bmi = if (height > 0 && weight > 0) weight / (height / 100).pow(2) else 0.0f

    val Blue = Color(0xFF0000FF)
    val Green = Color(0xFF00FF00)
    val Red = Color(0xFFFF0000)

    var warnColor = if (bmi < 18.5) Blue else if (bmi < 25) Green else Red
    Column {
        Text(
            text = stringResource(R.string.bmi_calculator),
            fontSize = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = heightInput,
                onValueChange = { heightInput = it.replace(',', '.') },
                label = { Text(stringResource(R.string.height)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .width(150.dp)
                    .padding(start = 8.dp, end = 8.dp),
            )
            OutlinedTextField(
                value = weightInput,
                onValueChange = { weightInput = it.replace(',', '.') },
                label = { Text(stringResource(R.string.weight)) },
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .width(150.dp)
                    .padding(start = 1.dp),
            )
            Text(
                text = stringResource(R.string.result, String.format("%.2f", bmi)),
                color = warnColor,
                modifier = Modifier
                    .width(200.dp)
                    .padding(start = 8.dp, top = 21.dp, bottom = 20.dp)
                    .weight(3f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Viikko2IN00CT073007Theme {
        BmiCalculator()
    }
}