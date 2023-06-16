package com.george_georgy.bonobono.feature_meal.presentation.category_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.george_georgy.bonobono.feature_meal.presentation.util.Screens
import com.george_georgy.bonobono.feature_meal.presentation.category_list.components.CategoryGridItem
import com.george_georgy.bonobono.feature_meal.presentation.ui.theme.ApricotColor
import com.george_georgy.bonobono.feature_meal.presentation.ui.theme.BalticSeaColor


@Composable
fun CategoryListScreen(
    navController: NavController, viewModel: CategoryViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 28.dp, end = 20.dp)
            .background(BalticSeaColor)


    ) {
        Column {
            Row() {

                Text(
                    text = "Bono Bono",
                    fontSize = 24.sp,
                    modifier = Modifier.weight(0.75f),
                    color = ApricotColor

                )
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "",
                    Modifier
                        .size(35.dp)
                        .weight(0.25f),
                    tint = ApricotColor

                )
            }

            Text(
                text = "You can eat \nany tasty food!",
                fontSize = 24.sp,
                fontWeight = Bold,
                maxLines = 2,
                textAlign = TextAlign.Start,
                color = ApricotColor

            )
            Spacer(modifier = Modifier.height(10.dp))


            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(state.categories) {
                    CategoryGridItem(category = it, onClick = { category ->
                        navController.navigate(Screens.CategoryDetailScreen.route + "/${category.strCategory}")
                    })
                }
            }

            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)

                )
            }


        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center), color = ApricotColor
            )
        }
    }

}


