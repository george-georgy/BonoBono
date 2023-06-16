package com.george_georgy.bonobono.feature_meal.presentation.util

sealed class Screens(val route : String) {
    object SplashScreen : Screens("Splash_Screen")
    object CategoryListScreen : Screens("category_list_screen")
    object CategoryDetailScreen : Screens("category_detail_screen")
    object MealDetailScreen : Screens("Meal_detail_screen")
    object FavoriteScreen : Screens("favorite_screen")


}