package com.george_georgy.bonobono.feature_meal.presentation.category_detail_list

import com.george_georgy.bonobono.feature_meal.domain.model.CategoryDetail

data class CategoryDetailState (
    val isLoading : Boolean = false,
    val categoryDetailList : List<CategoryDetail> = emptyList(),
    val error : String = ""
)
