package com.example.cofeeapp.domain.usecase

import com.example.cofeeapp.domain.model.OrderMode
import com.example.cofeeapp.domain.model.OrderSummary

fun calculateOrder(
    coffeePrice: Double,
    orderMode: OrderMode,
    deliveryFee: Double
): OrderSummary {
    return when(orderMode) {
        OrderMode.DINE_IN ->
            OrderSummary(
                coffeePrice = coffeePrice,
                deliveryFee = 0.0,
                cashbackEarned = coffeePrice * 0.10,
                totalPrice = coffeePrice,
                orderMode = OrderMode.DINE_IN
            )

        OrderMode.DELIVERY ->
            OrderSummary(
                coffeePrice = coffeePrice,
                deliveryFee = deliveryFee,
                cashbackEarned = coffeePrice * 0.05,
                totalPrice = coffeePrice + deliveryFee,
                orderMode = OrderMode.DELIVERY
            )
    }
}