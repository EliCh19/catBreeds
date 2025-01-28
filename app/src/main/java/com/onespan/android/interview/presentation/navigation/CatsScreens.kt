package com.onespan.android.interview.presentation.navigation

enum class CatsScreens {
    SplashScreen,
    HomeScreen;

    companion object {
        fun fromRoute(route: String?): CatsScreens {
            return when (route?.substringBefore("/")) {
                SplashScreen.name -> SplashScreen
                HomeScreen.name -> HomeScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not recognized")
            }
        }
    }
}