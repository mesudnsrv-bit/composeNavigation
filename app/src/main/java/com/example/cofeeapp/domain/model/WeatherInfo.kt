package com.example.cofeeapp.domain.model

import android.health.connect.datatypes.units.Temperature

data class WeatherInfo(
    val cityName: String,
    val temperature: Int,
    val condition: String,
    val isWeatherGood: Boolean
)
