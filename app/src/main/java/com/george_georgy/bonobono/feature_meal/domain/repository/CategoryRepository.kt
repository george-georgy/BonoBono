package com.george_georgy.bonobono.feature_meal.domain.repository

import com.george_georgy.bonobono.core.util.Resource
import com.george_georgy.bonobono.feature_meal.domain.model.Category
import com.george_georgy.bonobono.feature_meal.domain.model.CategoryDetail
import com.george_georgy.bonobono.feature_meal.domain.model.MealDetail
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
     fun getCategoryFromRemote(): Flow<Resource<List<Category>>>

     fun getCategoryDetailFromRemote(strCategory : String): Flow<Resource<List<CategoryDetail>>>

     fun getMealById(idMeal : String) : Flow<Resource<MealDetail>>

}