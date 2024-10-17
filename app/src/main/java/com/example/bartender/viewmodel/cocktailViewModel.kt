package com.example.bartender.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.bartender.repository.CocktailRepository
import com.example.bartender.model.Cocktail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class CocktailViewModel @Inject constructor(
    private val repository: CocktailRepository
) : ViewModel() {

    private val _cocktailList = MutableStateFlow<List<Cocktail>>(emptyList())
    val cocktailList: StateFlow<List<Cocktail>> = _cocktailList

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun searchCocktail(name: String) {
        _loading.value = true
        viewModelScope.launch {
            try {
                val response = repository.searchCocktailByName(name)
                _cocktailList.value = response.drinks ?: emptyList()
                _error.value = null
                _loading.value = false
            } catch (e: Exception) {
                _error.value = "Could not load data. Please try again."
                Log.e("CocktailViewModel", "Error fetching cocktail data: ${e.message}")
                _loading.value = false
            }
        }
    }

    fun getRandomCocktail() {
        _loading.value = true
        viewModelScope.launch {
            try {
                val response = repository.getRandomCocktail()
                _cocktailList.value = response.drinks ?: emptyList()
                _loading.value = false
            } catch (e: Exception) {
                _error.value = "Error: ${e.message}"
                _loading.value = false
            }
        }
    }
}