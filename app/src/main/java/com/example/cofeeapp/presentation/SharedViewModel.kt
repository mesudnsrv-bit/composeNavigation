package com.example.cofeeapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    var cashbackBalance by mutableDoubleStateOf(0.00)
        private set

    fun addCashback(price: Double) {
        val earned = price * 0.05
        cashbackBalance += earned
    }
}