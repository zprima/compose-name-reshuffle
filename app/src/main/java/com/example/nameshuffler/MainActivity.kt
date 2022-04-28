package com.example.nameshuffler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nameshuffler.ui.screen.NameScreen
import com.example.nameshuffler.ui.screen.NameViewModel
import com.example.nameshuffler.ui.screen.ShuffleScreen
import com.example.nameshuffler.ui.theme.NameShufflerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NameShufflerTheme {
                val viewModel: NameViewModel = viewModel()

                NavHost(navController = navController, startDestination = "name") {
                    composable("name") { NameScreen(navController, viewModel) }
                    composable("shuffle") { ShuffleScreen(navController, viewModel) }
                }
            }
        }
    }
}


