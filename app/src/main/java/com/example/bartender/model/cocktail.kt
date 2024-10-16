package com.example.bartender.model

import com.google.gson.annotations.SerializedName

data class Cocktail(
    @SerializedName("idDrink") val idDrink: String,
    @SerializedName("strDrink") val name: String,
    @SerializedName("strCategory") val category: String,
    @SerializedName("strAlcoholic") val alcoholic: String,
    @SerializedName("strGlass") val glass: String,
    @SerializedName("strInstructions") val instructions: String,
    @SerializedName("strDrinkThumb") val imageUrl: String
)