package com.onespan.android.interview.presentation.navigation

enum class CatsScreens {
    SplashScreen,
    HomeScreen,
    DetailScreen;

    companion object {
        fun fromRoute(route: String?): CatsScreens {
            return when (route?.substringBefore("/")) {
                SplashScreen.name -> SplashScreen
                HomeScreen.name -> HomeScreen
                DetailScreen.name -> DetailScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }
        }
    }
}