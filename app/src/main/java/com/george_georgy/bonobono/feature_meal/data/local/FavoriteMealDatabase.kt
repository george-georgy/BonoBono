package com.george_georgy.bonobono.feature_meal.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.george_georgy.bonobono.feature_meal.data.local.FavoriteMealDao
import com.george_georgy.bonobono.feature_meal.data.local.entity.Meal

@Database(
    entities = [Meal::class],
    version = 1
)
abstract class FavoriteMealDatabase : RoomDatabase() {

    abstract val dao : FavoriteMealDao
}