package com.example.cofeeapp.data.remote

data class WeatherResponse(
    val current_weather: CurrentWeather
)

data class CurrentWeather(
    val temperature: Double,
    val weathercode: Int
)