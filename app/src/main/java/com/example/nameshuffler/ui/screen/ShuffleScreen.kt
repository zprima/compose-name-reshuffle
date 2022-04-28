package com.example.nameshuffler.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun ShuffleScreen(
    navController: NavController,
    viewModel: NameViewModel = viewModel()
) {
    LaunchedEffect(true){
        viewModel.generateSomeNames()
    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            viewModel.uiState.shuffledNames.forEach {
                Text(it, fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue, contentColor = Color.White),
                onClick = { viewModel.generateSomeNames()}){
                Text("Reshuffle", fontSize = 16.sp)
            }

            Button(onClick = { navController.popBackStack() }) {
                Text("Back")
            }
        }
    }
}