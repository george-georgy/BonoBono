package com.george_georgy.bonobono.feature_meal.presentation.meal_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.george_georgy.bonobono.core.util.Resource
import com.george_georgy.bonobono.feature_meal.data.local.entity.Meal
import com.george_georgy.bonobono.feature_meal.domain.use_case.add_favorite_meal.AddFavoriteMeal
import com.george_georgy.bonobono.feature_meal.domain.use_case.get_meal.GetMeal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(
    private val getMeal: GetMeal,
    private val addFavoriteMeal: AddFavoriteMeal,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MealState())
    val state: State<MealState> = _state

    init {
        savedStateHandle.get<String>("idMeal")?.let { idMeal ->
            getCategories(idMeal)
        }
    }

    private fun getCategories(idMeal: String) {
        getMeal(idMeal).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MealState(
                        mealDetail = result.data
                    )

                }

                is Resource.Error -> {
                    _state.value = MealState(
                        error = result.message ?: "An unexpected error occurred"
                    )

                }

                is Resource.Loading -> {
                    _state.value = MealState(
                        isLoading = true
                    )

                }

            }
        }.launchIn(viewModelScope)
    }

    fun addMeal(meal: Meal) {
        viewModelScope.launch {
            addFavoriteMeal(meal)
        }
    }

}