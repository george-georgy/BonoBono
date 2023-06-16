package com.george_georgy.bonobono.feature_meal.presentation.meal_detail

import com.george_georgy.bonobono.feature_meal.domain.model.MealDetail

data class MealState(
    val isLoading: Boolean = false,
    val mealDetail: MealDetail? = null,
    val error: String = ""
)