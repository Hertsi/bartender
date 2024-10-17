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
    Row(
        modifier = Modifier
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
            Spacer(modifier = Modifier.height(8.dp))

            val ingredients = listOfNotNull(
                cocktail.measure1 to cocktail.ingredient1,
                cocktail.measure2 to cocktail.ingredient2,
                cocktail.measure3 to cocktail.ingredient3,
                cocktail.measure4 to cocktail.ingredient4,
                cocktail.measure5 to cocktail.ingredient5,
                cocktail.measure6 to cocktail.ingredient6,
                cocktail.measure7 to cocktail.ingredient7,
                cocktail.measure8 to cocktail.ingredient8,
                cocktail.measure9 to cocktail.ingredient9,
                cocktail.measure10 to cocktail.ingredient10,
                cocktail.measure11 to cocktail.ingredient11,
                cocktail.measure12 to cocktail.ingredient12,
                cocktail.measure13 to cocktail.ingredient13,
                cocktail.measure14 to cocktail.ingredient14,
                cocktail.measure15 to cocktail.ingredient15
            ).filter { it.second != null }

            if (ingredients.isNotEmpty()) {
                Text(text = "Ingredients:", style = androidx.compose.material3.MaterialTheme.typography.bodyMedium)
                ingredients.forEach { (measure, ingredient) ->
                    Text(text = "${measure ?: ""} $ingredient", style = androidx.compose.material3.MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}