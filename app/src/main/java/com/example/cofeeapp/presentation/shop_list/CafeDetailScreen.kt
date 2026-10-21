package com.example.cofeeapp.presentation.delivery

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.cofeeapp.R

data class CoffeeItem(val name: String, val price: Double)

@Composable
fun CafeDetailScreen(
    cafeName: String,
    onOrderSuccess: (Double) -> Unit,
    onBackClick: () -> Unit,
    onHomeClick: () -> Unit
) {
    val context = LocalContext.current
    val coffeeList = listOf(
        CoffeeItem("Cappuccino", 5.00),
        CoffeeItem("Americano", 4.00),
        CoffeeItem("Latte", 5.50),
        CoffeeItem("Espresso", 3.50),
        CoffeeItem("Mocha", 6.00)
    )

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
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 24.dp)
        ) {
            item {
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(text = cafeName, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = "Çatdırılma haqqı: 2.00 AZN", style = MaterialTheme.typography.bodyMedium)
                        Text(text = "Qazanılacaq Cashback: 5%", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                Text(text = "Kofe Menyusu", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))
            }

            items(coffeeList) { coffee ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = coffee.name, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.Medium)
                            Text(text = "${coffee.price} AZN", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                        }

                        Button(
                            onClick = {
                                onOrderSuccess(coffee.price)
                                Toast.makeText(context, "${coffee.name} sifariş olundu! Cashback əlavə edildi.", Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Text("Sifariş et")
                        }
                    }
                }
            }
        }
    }
}