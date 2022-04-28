package com.example.nameshuffler.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun NameScreen(
    navController: NavController,
    viewModel: NameViewModel = viewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            TextField(
                textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                placeholder = { Text("Name")},
                value = viewModel.uiState.name,
                onValueChange = {
                    viewModel.updateName(it)
                }
            )

            Button(onClick = { navController.navigate("shuffle") }) {
                Text("Shuffle")
            }
        }

    }
}