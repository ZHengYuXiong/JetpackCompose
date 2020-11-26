package com.example.jetpackcomposedemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.example.jetpackcomposedemo.ui.home.Home
import com.example.jetpackcomposedemo.ui.profile.Profile
import com.example.jetpackcomposedemo.ui.theme.JetpackComposeDemoTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoTheme {
                Surface(color = MaterialTheme.colors.background) {
                    AppContent()
                }
            }
        }
    }
}

@Preview
@Composable
fun AppContent() {
    Home()
}

@Preview
@Composable
fun Profile() {
    Profile()
}