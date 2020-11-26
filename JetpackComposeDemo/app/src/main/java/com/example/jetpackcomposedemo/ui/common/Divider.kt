package com.example.jetpackcomposedemo.ui.common


import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.jetpackcomposedemo.state.isLightTheme

/**
 * 绘制分割线
 */
@Composable
fun CustomDivider() {
    Divider(color = if (isLightTheme()) Color(0xFFEEEEEE) else Color(0xFF333333))
}