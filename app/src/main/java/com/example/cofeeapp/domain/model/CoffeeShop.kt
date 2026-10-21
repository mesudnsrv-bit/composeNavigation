package com.example.cofeeapp.domain.model

data class CoffeeShop(
    val id: Int,
    val name: String,
    val cityName: String,
    val menu: List<Coffee>,
    val deliveryFee: Double
)
