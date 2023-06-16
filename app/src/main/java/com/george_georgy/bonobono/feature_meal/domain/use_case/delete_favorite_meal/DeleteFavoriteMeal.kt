package com.george_georgy.bonobono.feature_meal.domain.use_case.delete_favorite_meal

import com.george_georgy.bonobono.feature_meal.data.local.entity.Meal
import com.george_georgy.bonobono.feature_meal.domain.repository.FavoriteRepository

class DeleteFavoriteMeal(
    private val favoriteRepository: FavoriteRepository
) {

    suspend operator fun invoke(meal : Meal) {
        return favoriteRepository.deleteMeal(meal)
    }
}