package com.george_georgy.bonobono.feature_meal.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.george_georgy.bonobono.feature_meal.data.local.entity.Meal
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(meal: Meal)

    @Delete
    suspend fun deleteMeal(meal : Meal)

    @Query("SELECT * FROM  Meal")
    fun getMeals() : Flow<List<Meal>>
}