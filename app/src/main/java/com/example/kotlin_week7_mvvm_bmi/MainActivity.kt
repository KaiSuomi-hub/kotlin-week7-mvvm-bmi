package com.example.kotlin_week7_mvvm_bmi.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.kotlin_week7_mvvm_bmi.databinding.ActivityMainBinding

import com.example.kotlin_week7_mvvm_bmi.BMIModel
import com.example.kotlin_week7_mvvm_bmi.BMIViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: BMIViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Observe LiveData from ViewModel
        viewModel.bmiResult.observe(this, Observer { bmi ->
            binding.textViewBmiResult.text = String.format("BMI: %.2f", bmi)
        })

        viewModel.bmiCategory.observe(this, Observer { category ->
            binding.textViewBmiCategory.text = "Category: $category"
        })

        // Handle button click for BMI calculation
        binding.buttonCalculate.setOnClickListener {
            val weight = binding.editTextWeight.text.toString()
            val height = binding.editTextHeight.text.toString()
            viewModel.calculateBMI(weight, height)
        }
    }
}