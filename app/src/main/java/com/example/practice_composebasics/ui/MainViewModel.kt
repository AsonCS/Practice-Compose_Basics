package com.example.practice_composebasics.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    enum class CurrentScreen {
        BusinessCardApp,
        ComposeArticle,
        ComposeQuadrant,
        TaskManager,
    }

    data class UiState(
        val currentScreen: CurrentScreen = CurrentScreen.ComposeArticle,
        val useDarkTheme: Boolean? = null
    )

    private val _uiUiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> get() = _uiUiState

    fun setupTheme(useDarkTheme: Boolean) {
        if (_uiUiState.value.useDarkTheme == null) {
            _uiUiState.update {
                it.copy(
                    useDarkTheme = useDarkTheme
                )
            }
        }
    }

    fun toggleScreen() {
        val state = when (_uiUiState.value.currentScreen) {
            CurrentScreen.BusinessCardApp ->
                CurrentScreen.ComposeArticle
            CurrentScreen.ComposeArticle ->
                CurrentScreen.TaskManager
            CurrentScreen.ComposeQuadrant ->
                CurrentScreen.BusinessCardApp
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
        val useDarkTheme = _uiUiState.value.useDarkTheme
            ?: return

        _uiUiState.update {
            it.copy(
                useDarkTheme = useDarkTheme.not()
            )
        }
    }

}
