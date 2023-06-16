package com.george_georgy.bonobono.feature_meal.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Meal (
    @PrimaryKey(autoGenerate = true)
    val idMeal: Int,
    val strMeal: String,
    val strArea: String,
    val strCategory: String,
    val strMealThumb : String
) {



}