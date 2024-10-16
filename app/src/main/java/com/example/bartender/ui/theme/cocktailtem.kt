package com.example.bartender.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.bartender.model.Cocktail

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CocktailItem(cocktail: Cocktail) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    ) {
        Image(
            painter = rememberImagePainter(cocktail.imageUrl),
            contentDescription = cocktail.name,
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Textual information
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(text = cocktail.name, style = androidx.compose.material3.MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Instructions: ${cocktail.instructions}")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Category: ${cocktail.category}")
            Text(text = "Glass: ${cocktail.glass}")
        }
    }
}