package com.george_georgy.bonobono.feature_meal.data.repository

import com.george_georgy.bonobono.feature_meal.data.local.FavoriteMealDao
import com.george_georgy.bonobono.feature_meal.data.local.entity.Meal
import com.george_georgy.bonobono.feature_meal.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class FavoriteRepositoryImpl(
    private val dao : FavoriteMealDao
) : FavoriteRepository {

    override suspend fun insertMeal(meal: Meal) {
         dao.insertMeal(meal)
    }

    override suspend fun deleteMeal(meal: Meal) {
         dao.deleteMeal(meal)
    }

    override fun getMeals(): Flow<List<Meal>> {
        return dao.getMeals()
    }
}