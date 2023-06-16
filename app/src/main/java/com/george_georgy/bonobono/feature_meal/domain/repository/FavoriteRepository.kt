package com.george_georgy.bonobono.feature_meal.domain.repository


import com.george_georgy.bonobono.feature_meal.data.local.entity.Meal
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {

    suspend fun insertMeal(meal: Meal)

    suspend fun deleteMeal(meal : Meal)

    fun getMeals() : Flow<List<Meal>>
}
