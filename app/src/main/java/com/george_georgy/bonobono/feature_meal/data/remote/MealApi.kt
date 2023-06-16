package com.george_georgy.bonobono.feature_meal.data.remote

import com.george_georgy.bonobono.feature_meal.data.remote.dto.CategoryDetailDto
import com.george_georgy.bonobono.feature_meal.data.remote.dto.CategoryDto
import com.george_georgy.bonobono.feature_meal.data.remote.dto.MealDetailDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {

    companion object{
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
    }

    @GET("categories.php")
    suspend fun getCategories() : CategoryDto

    @GET("filter.php?")
    suspend fun getCategoryDetail(@Query("c") strCategory : String) : CategoryDetailDto


    @GET("lookup.php?i=52772")
    suspend fun getMealById(@Query("i") idMeal : String) : MealDetailDto
}