package com.example.jetpackcomposedemo.state

import com.example.jetpackcomposedemo.lightThemeColors
import com.example.jetpackcomposedemo.models.User

sealed class Screen {
    object Home : Screen()
    data class Profile(val user: User) : Screen()
    object Compose : Screen()
}

object AppState {
    var currentScreen: Screen = Screen.Home
    var theme = lightThemeColors
}

fun navigateTo(destination: Screen) {
    AppState.currentScreen = destination
}

fun isLightTheme(): Boolean {
    return AppState.theme.isLight
}