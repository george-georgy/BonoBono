package com.george_georgy.bonobono.feature_meal.presentation.category_list

import com.george_georgy.bonobono.feature_meal.domain.model.Category

data class CategoryState(
    val isLoading : Boolean = false,
    val categories : List<Category> = emptyList(),
    val error : String = ""
)