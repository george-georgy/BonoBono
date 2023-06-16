package com.george_georgy.bonobono.feature_meal.presentation.favorite_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.george_georgy.bonobono.feature_meal.data.local.entity.Meal
import com.george_georgy.bonobono.feature_meal.domain.use_case.delete_favorite_meal.DeleteFavoriteMeal
import com.george_georgy.bonobono.feature_meal.domain.use_case.get_favorite_meal.GetFavoriteMeal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteMealViewModel @Inject constructor(
    private val getFavoriteMeal: GetFavoriteMeal,
    private val deleteFavoriteMeal: DeleteFavoriteMeal
) : ViewModel() {

    private val _state = mutableStateOf(emptyList<Meal>())
    val state: State<List<Meal>> = _state


    init {
        getFavList()
    }

    private fun getFavList() {
        getFavoriteMeal().onEach {
            _state.value = it
        }.launchIn(viewModelScope)
    }

     fun deleteMeal(meal: Meal) {
        viewModelScope.launch {
            deleteFavoriteMeal(meal)
        }
    }

}