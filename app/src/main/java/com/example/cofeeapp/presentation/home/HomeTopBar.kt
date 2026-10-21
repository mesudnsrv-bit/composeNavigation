package com.example.cofeeapp.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import com.example.cofeeapp.R


@Composable
fun HomeTopBar(
    onProfileClick: () -> Unit = {},
    modifier: Modifier = Modifier
        .systemBarsPadding()
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Text(
            text = "Coffee App",
            style = MaterialTheme.typography.titleLarge
        )

        IconButton(onClick = onProfileClick) {
            Icon(
                painter = painterResource(id = R.drawable.profile_icon),
                contentDescription = null,
            )
        }
    }
}