package com.example.androiddevchallenge.component

import android.view.Window
import android.view.WindowManager
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun setStatusBarTransparent(window: Window) =
    MaterialTheme {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }