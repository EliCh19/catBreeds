package com.onespan.android.interview.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.onespan.android.interview.presentation.screens.SplashScreen
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
            HomeScreen(viewModel = viewModel)
        }
    }
}