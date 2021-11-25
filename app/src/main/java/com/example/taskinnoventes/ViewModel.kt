package com.example.taskinnoventes

import androidx.lifecycle.ViewModel
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class ViewModel: ViewModel() {

    fun isValidPanNumber(number: String?): Boolean{
        return if (number!!.length < 10){
            false
        } else{
            // Regex to check valid PAN Card number.
            val regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}"
            val p: Pattern = Pattern.compile(regex)

            val m: Matcher = p.matcher(number)
            m.matches()
        }
    }

    fun isValidDay(day: String): Boolean {
        return if (day.length == 2){
            day.toInt() <= 31
        } else {
            false
        }
    }

    fun isValidMonth(month: String): Boolean {
        return if (month.length == 2){
            month.toInt() <= 12
        } else {
            false
        }
    }

    fun isValidYear(year: String): Boolean {
        return if (year.length == 4){
            val year = year.toInt()
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            year <= currentYear
        } else{
            false
        }
    }
}