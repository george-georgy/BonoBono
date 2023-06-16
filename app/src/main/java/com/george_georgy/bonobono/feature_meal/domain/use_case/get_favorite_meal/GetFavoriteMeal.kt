package com.george_georgy.bonobono.feature_meal.domain.use_case.get_favorite_meal

import com.george_georgy.bonobono.feature_meal.data.local.entity.Meal
import com.george_georgy.bonobono.feature_meal.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteMeal(
    private val favoriteRepository: FavoriteRepository
) {
    operator fun invoke() : Flow<List<Meal>>{
        return favoriteRepository.getMeals()
    }
}