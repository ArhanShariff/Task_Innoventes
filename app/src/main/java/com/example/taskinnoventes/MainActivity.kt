package com.example.taskinnoventes

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.taskinnoventes.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewModel
    private lateinit var  binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =ViewModelProvider(this).get(ViewModel::class.java)

        binding.apply {
            panNumber.addTextChangedListener(textWatcher)
            day.addTextChangedListener(dayTextWatcher)
            month.addTextChangedListener(monthTextWatcher)
            year.addTextChangedListener(yearTextWatcher)
            nextBt.setOnClickListener {
                Snackbar.make(binding.root, "Details submitted successfully", Snackbar.LENGTH_LONG).show()
            }
            noPan.setOnClickListener {
                finish()
            }
        }

    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (viewModel.isValidPanNumber(s.toString())){
                binding.day.isEnabled = true
                binding.day.requestFocus()
            }else {
                binding.panNumber.error = "Invalid PAN Number"
                binding.panNumber.requestFocus()
                binding.day.isEnabled = false
            }
        }
    }

    private val dayTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
           if (viewModel.isValidDay(s.toString())){
               binding.month.isEnabled = true
               binding.month.requestFocus()
           } else {
               binding.day.error = "Invalid Day"
               binding.day.requestFocus()
               binding.month.isEnabled = false
           }
        }
    }

    private val monthTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
           if (viewModel.isValidMonth(s.toString())){
               binding.year.isEnabled = true
               binding.year.requestFocus()
           }else{
               binding.month.error = "Invalid Month"
               binding.month.requestFocus()
               binding.year.isEnabled = false
           }
        }
    }

    private val yearTextWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
        }
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (viewModel.isValidYear(s.toString())){
                binding.nextBt.isEnabled = true
            }else {
                binding.year.error = "Invalid Year"
                binding.year.requestFocus()
                binding.nextBt.isEnabled = false
            }
        }
    }

}