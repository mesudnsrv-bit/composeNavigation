package com.example.cofeeapp.presentation.navigation

import androidx.compose.runtime.Composable
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

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "home_screen"
    ) {
        // 1. Home Ekranı
        composable("home_screen") {
            HomeScreen(
                onProfileClick = {
                    navController.navigate("profile_screen")
                },
                onDineInClick = {
                    navController.navigate("main_screen")
                },
                onDeliveryClick = {
                    navController.navigate("delivery_screen")
                }
            )
        }

        // 2. Main Screen (Dine In / Hava proqnozu)
        composable("main_screen") {
            MainScreen(
                onCloseClick = {
                    navController.popBackStack("home_screen", inclusive = false)
                },
                onOnlineClick = {
                    navController.navigate("delivery_screen")
                },
                onLocationClick = {
                    navController.navigate("delivery_screen")
                }
            )
        }
        // 3. Profil Ekranı
        composable("profile_screen") {
            ProfileScreen(
                cashbackBalance = sharedViewModel.cashbackBalance,
                onBackClick = { navController.popBackStack() },
                onHomeClick = { navController.popBackStack("home_screen", inclusive = false) }
            )
        }

        // 4. Delivery / Kafelər Siyahısı Ekranı
        composable("delivery_screen") {
            DeliveryScreen(
                onCafeClick = { cafeName ->
                    navController.navigate("cafe_detail/$cafeName")
                },
                onBackClick = { navController.popBackStack() },
                onHomeClick = { navController.popBackStack("home_screen", inclusive = false) }
            )
        }

        // 5. Kafe Detal / Kofe Qiymətləri və Sifariş Ekranı
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