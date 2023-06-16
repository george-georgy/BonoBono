package com.george_georgy.bonobono.feature_meal.di

import android.app.Application
import androidx.room.Room
import com.george_georgy.bonobono.feature_meal.data.local.FavoriteMealDatabase
import com.george_georgy.bonobono.feature_meal.data.repository.FavoriteRepositoryImpl
import com.george_georgy.bonobono.feature_meal.domain.repository.FavoriteRepository
import com.george_georgy.bonobono.feature_meal.domain.use_case.add_favorite_meal.AddFavoriteMeal
import com.george_georgy.bonobono.feature_meal.domain.use_case.delete_favorite_meal.DeleteFavoriteMeal
import com.george_georgy.bonobono.feature_meal.domain.use_case.get_favorite_meal.GetFavoriteMeal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideFavoriteMealsDatabase(app: Application): FavoriteMealDatabase {
        return Room.databaseBuilder(
            app,
            FavoriteMealDatabase::class.java,
            "meal_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideFavRepo(db: FavoriteMealDatabase): FavoriteRepository {
        return FavoriteRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideFavUseCase(favoriteRepository : FavoriteRepository): GetFavoriteMeal {
        return GetFavoriteMeal(favoriteRepository)
    }

    @Provides
    @Singleton
    fun provideAddUseCase(favoriteRepository : FavoriteRepository): AddFavoriteMeal {
        return AddFavoriteMeal(favoriteRepository)
    }

    @Provides
    @Singleton
    fun provideDeleteUseCase(favoriteRepository : FavoriteRepository): DeleteFavoriteMeal {
        return DeleteFavoriteMeal(favoriteRepository)
    }
}