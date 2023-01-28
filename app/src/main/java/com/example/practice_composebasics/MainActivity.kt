package com.example.practice_composebasics

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practice_composebasics.ui.MainViewModel
import com.example.practice_composebasics.ui.component.MainButton
import com.example.practice_composebasics.ui.screen.*
import com.example.practice_composebasics.ui.theme.PracticeComposeBasicsTheme

class MainActivity : ComponentActivity() {

    private fun getInitialMainViewModel(): MainViewModel {
        return MainViewModel(
            sharedPreferences = getSharedPreferences(
                /* name = */ "ComposeBasics",
                /* mode = */ Context.MODE_PRIVATE
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel = viewModel(initializer = { getInitialMainViewModel() })
            viewModel.setupTheme(
                isSystemInDarkTheme()
            )
            val uiState by viewModel.uiState.collectAsState()

            val useDarkTheme = uiState.useDarkTheme ?: false
            PracticeComposeBasicsTheme(
                useDarkTheme = useDarkTheme
            ) {
                window.navigationBarColor = MaterialTheme.colorScheme.background.toArgb()
                window.statusBarColor = MaterialTheme.colorScheme.background.toArgb()
                WindowCompat.getInsetsController(window, window.decorView)
                    .let {
                        it.isAppearanceLightNavigationBars = useDarkTheme.not()
                        it.isAppearanceLightStatusBars = useDarkTheme.not()
                    }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box {
                        when (uiState.currentScreen) {
                            MainViewModel.CurrentScreen.Screen1ComposeArticle ->
                                ComposeArticleApp()
                            MainViewModel.CurrentScreen.Screen2TaskManager ->
                                TaskManagerApp()
                            MainViewModel.CurrentScreen.Screen3ComposeQuadrant ->
                                ComposeQuadrantApp()
                            MainViewModel.CurrentScreen.Screen4BusinessCard ->
                                BusinessCardApp()
                            MainViewModel.CurrentScreen.Screen5DiceRoller ->
                                DiceRollerApp()
                            MainViewModel.CurrentScreen.Screen6Lemonade ->
                                LemonadeApp()
                            MainViewModel.CurrentScreen.Screen7TipTime ->
                                TipTimeApp()
                        }
                        MainButton(
                            toggleScreen = viewModel::toggleScreen,
                            toggleTheme = viewModel::toggleTheme,
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                        )
                    }
                }
            }
        }
    }
}
