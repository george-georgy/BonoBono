package com.george_georgy.bonobono.feature_meal.presentation.category_detail_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.george_georgy.bonobono.core.util.Resource
import com.george_georgy.bonobono.feature_meal.domain.use_case.get_category_detail.GetCategoryDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    private val getCategoryDetail: GetCategoryDetail,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CategoryDetailState())
    val state: State<CategoryDetailState> = _state


    init {
        savedStateHandle.get<String>("strCategory")?.let { strCategory ->
            getCategoriesDetail(strCategory)
        }
    }

    private fun getCategoriesDetail(strCategory: String) {
        getCategoryDetail(strCategory).onEach { result ->
            when (result) {
                is Resource.Success ->{
                    _state.value = CategoryDetailState(
                        categoryDetailList = result.data ?: emptyList())

                }
                is Resource.Error ->{
                    _state.value = CategoryDetailState(
                        error = result.message ?: "An unexpected error occurred")

                }
                is Resource.Loading ->{
                    _state.value = CategoryDetailState(
                        isLoading = true)

                }

            }
        }.launchIn(viewModelScope)
    }

}