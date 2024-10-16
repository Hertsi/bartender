package com.example.bartender.network

import com.example.bartender.model.CocktailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailApiService {

    @GET("search.php")
    suspend fun searchCocktailByName(@Query("s") name: String): CocktailResponse

    @GET("random.php")
    suspend fun getRandomCocktail(): CocktailResponse
}