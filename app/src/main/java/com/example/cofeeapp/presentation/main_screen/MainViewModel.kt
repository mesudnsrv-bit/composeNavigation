package com.example.cofeeapp.presentation.main_screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cofeeapp.data.remote.WeatherApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    var temperature by mutableStateOf("--°C")
        private set

    var weatherDescription by mutableStateOf("Məlumat yüklənir...")
        private set

    // Cari seçilmiş şəhər (Default: Bakı)
    var selectedCity by mutableStateOf("Bakı")
        private set

    private val api: WeatherApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApiService::class.java)
    }

    init {
        fetchWeather(lat = 40.4093, lon = 49.8671, cityName = "Bakı")
    }

    // Şəhərə görə hava məlumatını çəkən funksiya
    fun fetchWeather(lat: Double, lon: Double, cityName:String) {
        selectedCity = cityName
        viewModelScope.launch {
            try {
                // Open-Meteo API-yə koordinatları ötürürük
                val response = api.getCurrentWeather(lat = lat, lon = lon)
                val temp = response.current_weather.temperature
                temperature = "$temp°C"
                weatherDescription = "$cityName üçün hava əladır! İsti qəhvə üçün əsl vaxtıdır."
            } catch (e: Exception) {
                Log.e("MainViewModel", "Weather fetch error: ${e.message}", e)
                weatherDescription = "Hava məlumatını yükləmək olmadı"
            }
        }
    }
}