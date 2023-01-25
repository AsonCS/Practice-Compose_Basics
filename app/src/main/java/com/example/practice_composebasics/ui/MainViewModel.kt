package com.example.practice_composebasics.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    enum class CurrentScreen {
        ComposeArticle
    }

    private val _uiState = MutableStateFlow(
        CurrentScreen.ComposeArticle
    )
    val uiState: StateFlow<CurrentScreen> get() = _uiState

    fun navigateToComposeArticle() {
        _uiState.update {
            CurrentScreen.ComposeArticle
        }
    }

}
