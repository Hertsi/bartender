package com.example.bartender.repository

import com.example.bartender.network.CocktailApiService
import com.example.bartender.model.CocktailResponse
import javax.inject.Inject

class CocktailRepository @Inject constructor(
    private val apiService: CocktailApiService
) {
    suspend fun searchCocktailByName(name: String) = apiService.searchCocktailByName(name)
    suspend fun getRandomCocktail() = apiService.getRandomCocktail()
}