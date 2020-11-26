package com.example.jetpackcomposedemo.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.preferredSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemo.R

/**
 * 底部栏组件模块
 */
@Composable
fun BottomBar() {
    BottomAppBar() {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            BottomBarIcon(R.drawable.ic_home_selected)
            BottomBarIcon(R.drawable.ic_search)
            BottomBarIcon(R.drawable.ic_notifications)
            BottomBarIcon(R.drawable.ic_dm)
        }
    }
}

@Composable
private fun BottomBarIcon(icon: Int) {
    IconButton(onClick = {}) {
        Image(
            imageResource(icon),
            modifier = Modifier.preferredSize(24.dp)
        )
    }
}