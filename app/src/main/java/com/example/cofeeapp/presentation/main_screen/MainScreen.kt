package com.example.cofeeapp.presentation.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
    onCloseClick: () -> Unit,
    onOnlineClick: () -> Unit,
    onLocationClick: () -> Unit,
    viewModel: MainViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            ) {
                MainTopBar(onBackClick = onCloseClick)

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            viewModel.fetchWeather(lat = 40.4093, lon = 49.8671, cityName = "Bakı")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (viewModel.selectedCity == "Bakı") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Text("Bakı")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        onClick = {
                            viewModel.fetchWeather(lat = 40.5897, lon = 49.6686, cityName = "Sumqayıt")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (viewModel.selectedCity == "Sumqayıt") MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Text("Sumqayıt")
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            WeatherVenue(
                temperature = viewModel.temperature,
                description = viewModel.weatherDescription
            )

            Spacer(modifier = Modifier.height(32.dp))

            MainActionSection(
                onOnlineClick = onOnlineClick,
                onLocationClick = onLocationClick
            )
        }
    }
}