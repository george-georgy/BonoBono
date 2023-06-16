package com.george_georgy.bonobono.feature_meal.di

import com.george_georgy.bonobono.feature_meal.data.remote.MealApi
import com.george_georgy.bonobono.feature_meal.data.repository.CategoryRepoImpl
import com.george_georgy.bonobono.feature_meal.domain.repository.CategoryRepository
import com.george_georgy.bonobono.feature_meal.domain.use_case.get_category.GetCategory
import com.george_georgy.bonobono.feature_meal.domain.use_case.get_category_detail.GetCategoryDetail
import com.george_georgy.bonobono.feature_meal.domain.use_case.get_meal.GetMeal
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttp() : OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    @Provides
    @Singleton
    fun provideMealApi(okHttpClient : OkHttpClient): MealApi {
        return Retrofit.Builder()
            .baseUrl(MealApi.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCategoryRepo(apiService: MealApi): CategoryRepository {
        return CategoryRepoImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideUseCase(categoryRepository: CategoryRepository): GetCategory {
        return GetCategory(categoryRepository)
    }

    @Provides
    @Singleton
    fun provideCategoryDetailUseCase(categoryRepository: CategoryRepository): GetCategoryDetail {
        return GetCategoryDetail(categoryRepository)
    }

    @Provides
    @Singleton
    fun provideGetMealUseCase(categoryRepository: CategoryRepository): GetMeal {
        return GetMeal(categoryRepository)
    }


}