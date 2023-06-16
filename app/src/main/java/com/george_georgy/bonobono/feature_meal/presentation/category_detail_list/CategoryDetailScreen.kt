package com.george_georgy.bonobono.feature_meal.presentation.category_detail_list


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.george_georgy.bonobono.feature_meal.presentation.util.Screens
import com.george_georgy.bonobono.feature_meal.presentation.category_detail_list.components.CategoryDetailListItem
import com.george_georgy.bonobono.feature_meal.presentation.ui.theme.popinsFonts


@Composable
fun CategoryDetailScreen(
    navController: NavController,
    viewModel: CategoryDetailViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, top = 18.dp, end = 10.dp),
    ) {
        Column {

            Text(
                text = "Category List",
                fontFamily = popinsFonts,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White
            )


            Spacer(modifier = Modifier.padding(8.dp))

            LazyColumn() {
                items(state.categoryDetailList) {
                    CategoryDetailListItem(
                        it,
                        onClick = { categoryDetail ->
                            navController.navigate(Screens.MealDetailScreen.route + "/${categoryDetail.idMeal}")
                        },
                    )
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }


    }
}