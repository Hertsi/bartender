package com.example.bartender

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import com.example.bartender.ui.theme.BartenderTheme
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.PaddingValues
import com.example.bartender.ui.theme.Navigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BartenderTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    BartenderTheme {
        Scaffold { innerPadding: PaddingValues ->
            Navigation(innerPadding = innerPadding)
        }
    }
}