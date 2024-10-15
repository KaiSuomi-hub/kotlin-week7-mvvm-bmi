package com.example.kotlin_week7_mvvm_bmi


class BMIModel {
    // Function to calculate BMI
    fun calculateBMI(weight: Double, height: Double): Double {
        return if (height > 0) {
            weight / (height * height)
        } else {
            0.0
        }
    }

    // Function to get BMI category
    fun getBMICategory(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi in 18.5..24.9 -> "Normal weight"
            bmi in 25.0..29.9 -> "Overweight"
            bmi >= 30.0 -> "Obese"
            else -> "Invalid"
        }
    }
}
