package com.example.cofeeapp.domain.model

data class OrderSummary(
    val coffeePrice: Double,
    val deliveryFee: Double,
    val cashbackEarned: Double,
    val totalPrice: Double,
    val orderMode: OrderMode
)
