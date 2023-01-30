package com.example.practice_composebasics.ui

import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.practice_composebasics.ui.screen.WebbTelescopeImage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MainViewModel(
    private val sharedPreferences: SharedPreferences? = null
) : ViewModel() {

    // region Main

    enum class CurrentScreen {
        Screen1ComposeArticle,
        Screen2TaskManager,
        Screen3ComposeQuadrant,
        Screen4BusinessCard,
        Screen5DiceRoller,
        Screen6Lemonade,
        Screen7TipTime,
        Screen8ArtSpace,
    }

    data class UiState(
        val currentScreen: CurrentScreen = CurrentScreen.Screen1ComposeArticle,
        val useDarkTheme: Boolean? = null
    )

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> get() = _uiState

    private val keyCurrentScreen = "keyCurrentScreen"
    private val keyUseDarkTheme = "keyUseDarkTheme"

    init {
        var currentScreen: CurrentScreen? = null
        var useDarkTheme: Boolean? = null
        withSharedPreferences {
            all.forEach { (key, value) ->
                when {
                    key == keyCurrentScreen && value is String ->
                        currentScreen = CurrentScreen.valueOf(value)
                    key == keyUseDarkTheme && value is Boolean ->
                        useDarkTheme = value
                }
            }
        }
        if (currentScreen != null || useDarkTheme != null) {
            _uiState.update {
                UiState(
                    currentScreen = currentScreen ?: CurrentScreen.Screen1ComposeArticle,
                    useDarkTheme = useDarkTheme
                )
            }
        }
    }

    fun setupTheme(useDarkTheme: Boolean) {
        if (uiState.value.useDarkTheme == null) {
            setTheme(useDarkTheme)
        }
    }

    fun toggleScreen() {
        setCurrentScreen(
            when (uiState.value.currentScreen) {
                CurrentScreen.Screen1ComposeArticle ->
                    CurrentScreen.Screen2TaskManager
                CurrentScreen.Screen2TaskManager ->
                    CurrentScreen.Screen3ComposeQuadrant
                CurrentScreen.Screen3ComposeQuadrant ->
                    CurrentScreen.Screen4BusinessCard
                CurrentScreen.Screen4BusinessCard ->
                    CurrentScreen.Screen5DiceRoller
                CurrentScreen.Screen5DiceRoller ->
                    CurrentScreen.Screen6Lemonade
                CurrentScreen.Screen6Lemonade ->
                    CurrentScreen.Screen7TipTime
                CurrentScreen.Screen7TipTime ->
                    CurrentScreen.Screen8ArtSpace
                CurrentScreen.Screen8ArtSpace ->
                    CurrentScreen.Screen1ComposeArticle
            }
        )
    }

    fun toggleTheme() {
        val useDarkTheme = uiState.value.useDarkTheme
            ?: return

        setTheme(useDarkTheme.not())
    }

    private fun setCurrentScreen(currentScreen: CurrentScreen) {
        _uiState.update {
            it.copy(
                currentScreen = currentScreen
            ).withSharedPreferences {
                edit()
                    .putString(keyCurrentScreen, currentScreen.name)
                    .apply()
            }
        }
    }

    private fun setTheme(useDarkTheme: Boolean) {
        _uiState.update {
            it.copy(
                useDarkTheme = useDarkTheme
            ).withSharedPreferences {
                edit()
                    .putBoolean(keyUseDarkTheme, useDarkTheme)
                    .apply()
            }
        }
    }

    private fun <T> T.withSharedPreferences(block: SharedPreferences.() -> Unit): T {
        runCatching {
            sharedPreferences?.run(block)
        }.getOrNull()
        return this
    }

    // endregion

    // region TipTime

    val costInputState = mutableStateOf("")
    val roundUpState = mutableStateOf(false)
    val tipPercentInputState = mutableStateOf("15")

    // endregion

    // region ArtSpace

    val webbTelescopeImageState =
        mutableStateOf<WebbTelescopeImage>(WebbTelescopeImage.CosmicCliffs)

    // endregion

}
