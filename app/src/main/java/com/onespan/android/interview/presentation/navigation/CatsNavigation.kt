package com.onespan.android.interview.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.onespan.android.interview.presentation.screens.SplashScreen
import com.onespan.android.interview.presentation.screens.detail.DetailScreen
import com.onespan.android.interview.presentation.screens.detail.DetailScreenViewModel
import com.onespan.android.interview.presentation.screens.home.HomeScreen
import com.onespan.android.interview.presentation.screens.home.HomeScreenViewModel

@Composable
fun CatsNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = CatsScreens.SplashScreen.name) {
        composable(CatsScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(CatsScreens.HomeScreen.name) {
            val viewModel = hiltViewModel<HomeScreenViewModel>()
            HomeScreen(viewModel = viewModel) { type ->
                navController.navigate("${CatsScreens.DetailScreen.name}/${type}")
            }
        }
        val detailsScreen = CatsScreens.DetailScreen.name
        composable(
            route = "$detailsScreen/{breed}",
            arguments = listOf(
                navArgument("breed") {
                    type = NavType.StringType
                })
        ) { backStackEntry ->
            val breed = backStackEntry.arguments?.getString("breed")
            val viewModel = hiltViewModel<DetailScreenViewModel>()

            if (breed != null) {
                DetailScreen(
                    navController = navController,
                    breed = breed,
                    viewModel = viewModel
                )
            }
        }
    }
}