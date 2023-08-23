package app.samruddhi.smartagro.presentation.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.samruddhi.smartagro.presentation.apnabazaar.ui.ApnaBazaar
import app.samruddhi.smartagro.presentation.home.ui.HomeScreen
import app.samruddhi.smartagro.presentation.login.ui.LoginScreen
import app.samruddhi.smartagro.presentation.selectCrop.ui.SelectCropScreen
import app.samruddhi.smartagro.presentation.weather.ui.Weather

@Composable
fun MainNavController() {
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController,
        startDestination = Screens.Login.route,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300),
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(300),
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(300),
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300),
            )
        },

        ) {
        composable(Screens.Login.route) {
            LoginScreen(navController = navHostController)
        }

        composable(Screens.SelectCrop.route) {
            SelectCropScreen(navHostController)
        }

        composable(Screens.Home.route) {
            HomeScreen(navController = navHostController)
        }

        composable(Screens.ApnaBazaar.route) {
            ApnaBazaar(navController = navHostController)
        }

        composable(Screens.Weather.route) {
            Weather()
        }


    }
}

