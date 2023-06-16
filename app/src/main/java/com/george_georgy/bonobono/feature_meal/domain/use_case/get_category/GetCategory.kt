package com.george_georgy.bonobono.feature_meal.domain.use_case.get_category

import com.george_georgy.bonobono.core.util.Resource
import com.george_georgy.bonobono.feature_meal.domain.model.Category
import com.george_georgy.bonobono.feature_meal.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class GetCategory (
    private val categoryRepo: CategoryRepository
    ) {

    operator fun invoke(): Flow<Resource<List<Category>>>  {
         return categoryRepo.getCategoryFromRemote()
    }
}