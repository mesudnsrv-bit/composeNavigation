package com.example.cofeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cofeeapp.presentation.SharedViewModel
import com.example.cofeeapp.presentation.delivery.CafeDetailScreen
import com.example.cofeeapp.presentation.delivery.DeliveryScreen
import com.example.cofeeapp.presentation.home.HomeScreen
import com.example.cofeeapp.presentation.main_screen.MainScreen
import com.example.cofeeapp.presentation.profile.ProfileScreen
import com.example.cofeeapp.ui.theme.CofeeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CofeeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val sharedViewModel: SharedViewModel = viewModel()

                    NavHost(
                        navController = navController,
                        startDestination = "home_screen"
                    ) {
                        composable("home_screen") {
                            HomeScreen(
                                onProfileClick = { navController.navigate("profile_screen") },
                                onDineInClick = { navController.navigate("main_screen") },
                                onDeliveryClick = { navController.navigate("delivery_screen") }
                            )
                        }

                        // MainScreen düymələri artıq Delivery/Kafelər siyahısına keçir
                        composable("main_screen") {
                            MainScreen(
                                onCloseClick = {
                                    navController.popBackStack()
                                },
                                onOnlineClick = {
                                    navController.navigate("delivery_screen")
                                },
                                onLocationClick = {
                                    navController.navigate("delivery_screen")
                                }
                            )
                        }

                        composable("profile_screen") {
                            ProfileScreen(
                                cashbackBalance = sharedViewModel.cashbackBalance,
                                onBackClick = { navController.popBackStack() },
                                onHomeClick = { navController.popBackStack("home_screen", inclusive = false) }
                            )
                        }

                        composable("delivery_screen") {
                            DeliveryScreen(
                                onCafeClick = { cafeName -> navController.navigate("cafe_detail/$cafeName") },
                                onBackClick = { navController.popBackStack() },
                                onHomeClick = { navController.popBackStack("home_screen", inclusive = false) }
                            )
                        }

                        composable("cafe_detail/{cafeName}") { backStackEntry ->
                            val cafeName = backStackEntry.arguments?.getString("cafeName") ?: "Kafe"
                            CafeDetailScreen(
                                cafeName = cafeName,
                                onOrderSuccess = { price ->
                                    sharedViewModel.addCashback(price)
                                },
                                onBackClick = { navController.popBackStack() },
                                onHomeClick = { navController.popBackStack("home_screen", inclusive = false) }
                            )
                        }
                    }
                }
            }
        }
    }
}