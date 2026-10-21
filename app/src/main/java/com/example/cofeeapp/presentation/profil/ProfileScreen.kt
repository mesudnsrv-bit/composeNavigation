package com.example.cofeeapp.presentation.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cofeeapp.R

@Composable
fun ProfileScreen(
    cashbackBalance: Double,
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(painter = painterResource(id = R.drawable.ic_back), contentDescription = "Geri")
                }
                IconButton(onClick = onHomeClick) {
                    Icon(painter = painterResource(id = R.drawable.ic_close), contentDescription = "Home")
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(24.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Profil Məlumatları", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(text = "Ad Soyad:", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Məsud Nəsirov", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "Cari Cashback:", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        text = String.format("%.2f AZN", cashbackBalance),
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}