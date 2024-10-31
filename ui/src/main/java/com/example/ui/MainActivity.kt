package com.example.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.rememberNavController
import com.example.ui.details.DetailsScreen
import com.example.ui.details.DetailsScreenRoute
import com.example.ui.main.MainScreen
import com.example.ui.main.MainScreenRoute


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = MainScreenRoute) {
                        composable<MainScreenRoute> {
                            MainScreen(navController = navController)
                        }
                        composable<DetailsScreenRoute> {
                            DetailsScreen(navController)
                        }
                    }
                }
            }
        }
    }
}