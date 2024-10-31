package com.example.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.Text

@Composable
fun DetailScreen(
    id: String = "",
    navController: NavController
){
    Column {
        Text(text = "Hello everyone!!!")
    }
}