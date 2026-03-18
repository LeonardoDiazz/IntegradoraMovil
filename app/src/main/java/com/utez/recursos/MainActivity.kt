package com.utez.recursos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.utez.recursos.ui.UtezRecursosApp
import com.utez.recursos.ui.theme.UtezRecursosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UtezRecursosTheme {
                UtezRecursosApp()
            }
        }
    }
}
