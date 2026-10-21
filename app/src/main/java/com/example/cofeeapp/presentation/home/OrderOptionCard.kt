package com.example.cofeeapp.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import com.example.cofeeapp.R
import androidx.compose.foundation.layout.height

@Composable
fun OrderOptionsSection(
    onDineInClick: () -> Unit,
    onDeliveryClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Button(
            onClick = onDineInClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_at_coffeeshop),
                contentDescription = null,
                modifier = Modifier.size(156.dp)
                    .padding(end = 16.dp)
            )
            Text(
                text = "Drinking at the coffee house (Cashback)",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White,
                modifier = Modifier.weight(1f),
                maxLines = 3,
            )
        }

        OutlinedButton(
            onClick = onDeliveryClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_online),
                contentDescription = null,
                modifier = Modifier.size(156.dp)
                    .padding(end = 16.dp)
            )
            Text(
                text = "To place an order online",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.weight(1f),
                maxLines = 3,
            )
        }
    }
}