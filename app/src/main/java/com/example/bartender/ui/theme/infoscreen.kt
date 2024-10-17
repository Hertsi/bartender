package com.example.bartender.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.ui.res.stringResource
import com.example.bartender.R

@Composable
fun InfoScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = stringResource(id = R.string.info_screen_title))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "This is a cocktail searching app using TheCocktailDB API.")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Back to Search")
        }
    }
}