package com.example.cofeeapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    // Sifariş verildikcə artan Cashback balansı (İlkin dəyər: 0.0)
    var cashbackBalance by mutableDoubleStateOf(0.00)
        private set

    // Sifariş zamanı cashback əlavə edən funksiya (5%)
    fun addCashback(price: Double) {
        val earned = price * 0.05
        cashbackBalance += earned
    }
}