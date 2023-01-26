package com.example.practice_composebasics.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    enum class CurrentScreen {
        ComposeArticle,
        ComposeQuadrant,
        TaskManager,
    }

    data class UiState(
        val currentScreen: CurrentScreen = CurrentScreen.ComposeArticle,
        val isDarkTheme: Boolean? = null
    )

    private val _uiUiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> get() = _uiUiState

    fun setupTheme(isDarkTheme: Boolean) {
        if (_uiUiState.value.isDarkTheme == null) {
            _uiUiState.update {
                it.copy(
                    isDarkTheme = isDarkTheme
                )
            }
        }
    }

    fun toggleScreen() {
        val state = when (_uiUiState.value.currentScreen) {
            CurrentScreen.ComposeArticle ->
                CurrentScreen.TaskManager
            CurrentScreen.ComposeQuadrant ->
                CurrentScreen.ComposeArticle
            CurrentScreen.TaskManager ->
                CurrentScreen.ComposeQuadrant
        }
        _uiUiState.update {
            it.copy(
                currentScreen = state
            )
        }
    }

    fun toggleTheme() {
        val isDarkTheme = _uiUiState.value.isDarkTheme
            ?: return

        _uiUiState.update {
            it.copy(
                isDarkTheme = isDarkTheme.not()
            )
        }
    }

}
