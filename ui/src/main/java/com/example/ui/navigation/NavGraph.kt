package com.example.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ui.detail.DetailScreen
import com.example.ui.main.MainScreen


@Composable
fun NavGraph(
    modifier:Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController= navController,
        startDestination = Screens.MAIN.route
    ){
        composable(route = Screens.MAIN.route){
            MainScreen(navController = navController)
        }
        composable(route = Screens.DETAIL.route){
            DetailScreen(navController = navController)
        }
    }
}