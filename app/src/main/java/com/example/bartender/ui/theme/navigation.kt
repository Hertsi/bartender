package com.example.bartender.ui.theme

import CocktailSearchScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.PaddingValues

@Composable
fun Navigation(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "search") {
        composable(route = "search") {
            CocktailSearchScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}