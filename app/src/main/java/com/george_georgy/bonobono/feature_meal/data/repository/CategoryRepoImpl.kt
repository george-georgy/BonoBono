package com.george_georgy.bonobono.feature_meal.data.repository

import com.george_georgy.bonobono.core.util.Resource
import com.george_georgy.bonobono.feature_meal.data.remote.MealApi
import com.george_georgy.bonobono.feature_meal.domain.model.Category
import com.george_georgy.bonobono.feature_meal.domain.model.CategoryDetail
import com.george_georgy.bonobono.feature_meal.domain.model.MealDetail
import com.george_georgy.bonobono.feature_meal.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import retrofit2.HttpException
import java.io.IOException


class CategoryRepoImpl(
    private val mealApi: MealApi
) : CategoryRepository {

    override fun getCategoryFromRemote(): Flow<Resource<List<Category>>> = flow {

        try {
            emit(Resource.Loading<List<Category>>())
            val categories = mealApi.getCategories().categories
            emit(Resource.Success<List<Category>>(categories))

        } catch (e: HttpException) {
            emit(
                Resource.Error<List<Category>>(
                    message = e.localizedMessage ?: "A unexpected error occurred"
                )
            )

        } catch (e: IOException) {
            emit(
                Resource.Error<List<Category>>(
                    message = e.localizedMessage
                        ?: "Couldn't reach server. check your internet connection"
                )
            )
        }
    }

    override fun getCategoryDetailFromRemote(strCategory : String): Flow<Resource<List<CategoryDetail>>> = flow {
        try {
            emit(Resource.Loading<List<CategoryDetail>>())
            val categoryDetail = mealApi.getCategoryDetail(strCategory).meals
            emit(Resource.Success<List<CategoryDetail>>(categoryDetail))

        } catch (e: HttpException) {
            emit(
                Resource.Error<List<CategoryDetail>>(
                    message = e.localizedMessage ?: "A unexpected error occurred"
                )
            )

        } catch (e: IOException) {
            emit(
                Resource.Error<List<CategoryDetail>>(
                    message = e.localizedMessage
                        ?: "Couldn't reach server. check your internet connection"
                )
            )
        }
    }

    override fun getMealById(idMeal: String): Flow<Resource<MealDetail>> = flow{
        try {
            emit(Resource.Loading<MealDetail>())
            val mealDetail = mealApi.getMealById(idMeal).meals[0]
            emit(Resource.Success<MealDetail>(mealDetail))

        } catch (e: HttpException) {
            emit(
                Resource.Error<MealDetail>(
                    message = e.localizedMessage ?: "A unexpected error occurred"
                )
            )

        } catch (e: IOException) {
            emit(
                Resource.Error<MealDetail>(
                    message = e.localizedMessage
                        ?: "Couldn't reach server. check your internet connection"
                )
            )
        }
        }

}

