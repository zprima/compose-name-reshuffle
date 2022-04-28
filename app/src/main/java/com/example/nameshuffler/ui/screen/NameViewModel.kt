package com.example.nameshuffler.ui.screen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {
    var uiState by mutableStateOf(NameUiState())
        private set

    fun generateSomeNames(){
        val names = mutableListOf<String>()
        val name = uiState.name.toCharArray()

        for(i in 0..10){
            name.shuffle()
            names.add(name.joinToString(separator = "").lowercase())
        }

        uiState = uiState.copy(
            shuffledNames = names
        )
    }

    fun updateName(name: String){
        uiState = uiState.copy(
            name = name
        )
    }
}