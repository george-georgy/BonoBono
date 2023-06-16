package com.george_georgy.bonobono.feature_meal.domain.use_case.get_meal

import com.george_georgy.bonobono.core.util.Resource
import com.george_georgy.bonobono.feature_meal.domain.model.MealDetail
import com.george_georgy.bonobono.feature_meal.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMeal @Inject constructor(
    private val categoryRepo: CategoryRepository
    ) {
    operator fun invoke(idMeal: String): Flow<Resource<MealDetail>>  {
         return categoryRepo.getMealById(idMeal)
    }
}