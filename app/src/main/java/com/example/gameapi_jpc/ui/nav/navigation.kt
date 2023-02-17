package com.example.gameapi_jpc.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gameapi_jpc.ui.ViewModel.GameViewModel
import com.example.gameapi_jpc.ui.screens.DetailScreen
import com.example.gameapi_jpc.ui.screens.HomeScreen
import com.example.gameapi_jpc.util.Constants.Companion.KAY_GAME_ID
import com.example.gameapi_jpc.util.Constants.Screens.DETAIL_SCREEN
import com.example.gameapi_jpc.util.Constants.Screens.HOME_SCREEN

sealed class Screens(val route: String){
    object Home: Screens(route = HOME_SCREEN)
    object Detail: Screens(route = DETAIL_SCREEN)
}

@Composable
fun SetupNavHost(navController: NavHostController, gameViewModel: GameViewModel) {
    NavHost(navController = navController, startDestination = Screens.Home.route){
        composable(route = Screens.Home.route){
            HomeScreen(gameViewModel = gameViewModel, navController = navController)
        }
        composable(route = Screens.Detail.route + "/{$KAY_GAME_ID}"){backStackEntry ->
            DetailScreen(id = backStackEntry.arguments?.getString(KAY_GAME_ID) ?: "", gameViewModel = gameViewModel, navController = navController)
        }
    }
}