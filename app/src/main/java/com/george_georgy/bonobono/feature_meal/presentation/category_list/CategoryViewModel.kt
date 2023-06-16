package com.george_georgy.bonobono.feature_meal.presentation.category_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.george_georgy.bonobono.core.util.Resource
import com.george_georgy.bonobono.feature_meal.domain.use_case.get_category.GetCategory
import com.george_georgy.bonobono.feature_meal.presentation.category_list.CategoryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategory: GetCategory
) : ViewModel(){

    private val _state = mutableStateOf(CategoryState())
    val state: State<CategoryState> = _state

    init {
        getCategories()
    }

     private fun getCategories(){
        getCategory().onEach { result->
                when(result){
                    is Resource.Success ->{
                        _state.value = CategoryState(
                            categories = result.data ?: emptyList())

                    }
                    is Resource.Error ->{
                        _state.value = CategoryState(
                            error = result.message ?: "An unexpected error occurred")

                    }
                    is Resource.Loading ->{
                        _state.value = CategoryState(
                            isLoading = true)

                    }

                }
            }.launchIn(viewModelScope)
    }

}