package com.example.kotlin_week7_mvvm_bmi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class BMIViewModel : ViewModel() {

    private val bmiModel = BMIModel()

    // MutableLiveData for BMI and BMI Category
    private val _bmiResult = MutableLiveData<Double>()
    val bmiResult: LiveData<Double> get() = _bmiResult

    private val _bmiCategory = MutableLiveData<String>()
    val bmiCategory: LiveData<String> get() = _bmiCategory

    // Function to calculate BMI and update LiveData
    fun calculateBMI(weight: String, height: String) {
        try {
            val weightValue = weight.toDouble()
            val heightValue = height.toDouble()

            val bmi = bmiModel.calculateBMI(weightValue, heightValue)
            _bmiResult.value = bmi
            _bmiCategory.value = bmiModel.getBMICategory(bmi)
        } catch (e: Exception) {
            _bmiResult.value = 0.0
            _bmiCategory.value = "Invalid input"
        }
    }
}
