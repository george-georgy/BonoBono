package com.george_georgy.bonobono.feature_meal.domain.use_case.add_favorite_meal

import com.george_georgy.bonobono.feature_meal.data.local.entity.Meal
import com.george_georgy.bonobono.feature_meal.domain.repository.FavoriteRepository

class AddFavoriteMeal(
    private val favoriteRepository: FavoriteRepository
) {

    suspend operator fun invoke(meal : Meal) {
        return favoriteRepository.insertMeal(meal)
    }
}