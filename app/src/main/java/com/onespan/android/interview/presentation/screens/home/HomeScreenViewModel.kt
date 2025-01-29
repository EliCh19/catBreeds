package com.onespan.android.interview.presentation.screens.home

import Item
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onespan.android.interview.common.Resource
import com.onespan.android.interview.domain.repository.CatsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val repository: CatsRepository) :
    ViewModel() {
    var catsList: Item by mutableStateOf(Item())
        private set
    var isLoading: Boolean by mutableStateOf(true)

    init {
        getItems()
    }

    fun getItems() {
        viewModelScope.launch(Dispatchers.Main) {
            try {
                when (val response = repository.getBreeds()) {
                    is Resource.Success -> {
                        if (response.data != null) {
                            catsList = response.data
                            isLoading = false
                        } else {
                            Log.i("Network", "showCats: Failed to load cat breeds")
                        }
                    }

                    is Resource.Error -> {
                        isLoading = false
                        Log.i("Network", "showCats: Failed to load cat breeds")
                    }

                    else -> {
                        isLoading = false
                    }
                }
            } catch (e: Exception) {
                Log.d("Network", "showCats: ${e.message.toString()}")
            }
        }
    }
}