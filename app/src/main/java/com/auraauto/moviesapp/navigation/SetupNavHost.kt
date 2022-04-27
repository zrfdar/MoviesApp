package com.auraauto.moviesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.auraauto.moviesapp.MainViewModel
import com.auraauto.moviesapp.screens.DetailsScreen
import com.auraauto.moviesapp.screens.MainScreen
import com.auraauto.moviesapp.screens.SplashScreen
import com.auraauto.moviesapp.utils.Constants

sealed class Screens(val route: String){
    object Splash: Screens(Constants.Screens.SPLASH_SCREEN)
    object Main: Screens(Constants.Screens.MAIN_SCREEN)
    object Details: Screens(Constants.Screens.DETAILS_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController, viewModel: MainViewModel){
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.route
    ){
        composable(route = Screens.Splash.route){
            SplashScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Main.route){
            MainScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.Details.route + "/{Id}"){ backStackEntry ->
            DetailsScreen(navController = navController, viewModel = viewModel,
                itemid = backStackEntry.arguments?.getString("Id") ?: "1")

        }
    }
}