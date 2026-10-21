package com.example.cofeeapp.data.remote

import com.example.cofeeapp.data.remote.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("v1/forecast")
    suspend fun getCurrentWeather(
        @Query("latitude") lat: Double = 40.4093,
        @Query("longitude") lon: Double = 49.8671,
        @Query("current_weather") currentWeather: Boolean = true
    ): WeatherResponse
}