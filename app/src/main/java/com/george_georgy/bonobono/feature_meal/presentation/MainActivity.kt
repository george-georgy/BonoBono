package com.george_georgy.bonobono.feature_meal.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.george_georgy.bonobono.feature_meal.presentation.category_detail_list.CategoryDetailScreen
import com.george_georgy.bonobono.feature_meal.presentation.category_list.CategoryListScreen
import com.george_georgy.bonobono.feature_meal.presentation.favorite_list.FavoriteScreen
import com.george_georgy.bonobono.feature_meal.presentation.meal_detail.MealDetailScreen
import com.george_georgy.bonobono.feature_meal.presentation.splash_screen.SplashScreen
import com.george_georgy.bonobono.feature_meal.presentation.util.Screens
import com.george_georgy.bonobono.feature_meal.presentation.ui.theme.OrderAppTheme
import com.george_georgy.bonobono.feature_meal.presentation.ui.theme.BalticSeaColor

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrderAppTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BalticSeaColor)
                ) {
                    Navigation()
                }

            }
        }
    }
}

@Composable
private fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route
    ) {
        composable(
            route = Screens.SplashScreen.route
        ) {
            SplashScreen(navController)
        }
        composable(
            route = Screens.CategoryListScreen.route
        ) {
            CategoryListScreen(navController)
        }
        composable(route = Screens.CategoryDetailScreen.route + "/{strCategory}") {
            CategoryDetailScreen(navController)
        }
        composable(route = Screens.MealDetailScreen.route + "/{idMeal}") {
            MealDetailScreen(navController)
        }
        composable(route = Screens.FavoriteScreen.route) {
            FavoriteScreen(navController)
        }


    }

}



