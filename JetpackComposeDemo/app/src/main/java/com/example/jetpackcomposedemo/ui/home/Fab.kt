package com.example.jetpackcomposedemo.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.R
import com.example.jetpackcomposedemo.state.AppState
import com.example.jetpackcomposedemo.state.Screen
import com.example.jetpackcomposedemo.state.navigateTo

/**
 * 悬浮按钮组件模块
 */
@Composable
fun Fab() {
    FloatingActionButton(
            onClick = { navigateTo(Screen.Compose) },
            backgroundColor = AppState.theme.primary
    ) {
        Image(
                imageResource(R.drawable.ic_compose),
                modifier = Modifier
                        .preferredSize(25.dp)
        )
    }
}
