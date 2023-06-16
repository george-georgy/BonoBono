package com.george_georgy.bonobono.feature_meal.domain.use_case.get_category_detail

import com.george_georgy.bonobono.core.util.Resource
import com.george_georgy.bonobono.feature_meal.domain.model.CategoryDetail
import com.george_georgy.bonobono.feature_meal.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class GetCategoryDetail (
    private val categoryRepo: CategoryRepository
    ) {

    operator fun invoke(strCategory : String): Flow<Resource<List<CategoryDetail>>>  {
         return categoryRepo.getCategoryDetailFromRemote(strCategory)
    }
}