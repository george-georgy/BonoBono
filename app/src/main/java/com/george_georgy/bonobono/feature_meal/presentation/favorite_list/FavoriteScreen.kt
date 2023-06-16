package com.george_georgy.bonobono.feature_meal.presentation.favorite_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.george_georgy.bonobono.feature_meal.presentation.util.Screens
import com.george_georgy.bonobono.feature_meal.presentation.ui.theme.popinsFonts

@Composable
fun FavoriteScreen(
    navController: NavController, viewModel: FavoriteMealViewModel = hiltViewModel()

) {
    val state = viewModel.state

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, top = 18.dp, end = 10.dp)
    ) {

        Column {

            Text(
                text = "Favorite Meals",
                fontFamily = popinsFonts,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.White

            )


            Spacer(modifier = Modifier.padding(8.dp))

            LazyColumn {
                items(state.value) {
                    FavoriteMealListItem(meal = it, onClick = {
                        navController.navigate(Screens.MealDetailScreen.route + "/${it.idMeal}")

                    })
                }
            }

        }
    }
}