package com.george_georgy.bonobono.feature_meal.presentation.meal_detail

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.george_georgy.bonobono.feature_meal.presentation.util.Screens
import com.george_georgy.bonobono.feature_meal.presentation.ui.theme.ApricotColor
import com.george_georgy.bonobono.feature_meal.presentation.ui.theme.popinsFonts


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MealDetailScreen(
    navController: NavController, viewModel: MealViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val scrollState = rememberScrollState()
    val context = LocalContext.current



    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 28.dp, end = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {


            state.mealDetail?.let {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        Modifier
                            .size(25.dp)
                            .clickable {
                                navController.popBackStack()
                            },
                        tint = ApricotColor
                    )
                    Text(
                        text = it.strMeal,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f),
                        fontFamily = popinsFonts,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White

                    )
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite",
                        Modifier
                            .size(25.dp)
                            .clickable {
                                navController.navigate(Screens.FavoriteScreen.route)
                            },
                        tint = ApricotColor
                    )
                }


                GlideImage(
                    model = state.mealDetail.strMealThumb,
                    contentDescription = "",
                    modifier = Modifier
                        .size(275.dp)
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally)
                        .clip(RoundedCornerShape(18.dp))
                        .border(2.dp, ApricotColor),

                    )

                Spacer(modifier = Modifier.height(28.dp))

                Text(
                    text = "Meal Instruction",
                    fontFamily = popinsFonts,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = it.strInstructions,
                    fontFamily = popinsFonts,
                    fontSize = 14.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(12.dp))


                Button(
                    shape = RoundedCornerShape(20.dp),

                    onClick = {
                        viewModel.addMeal(state.mealDetail.toMeal())

                        Toast.makeText(context, "Meal added", Toast.LENGTH_SHORT).show()
                    },

                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ApricotColor
                    )

                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "add favorite button",
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                    Text(text = "ADD", fontSize = 16.sp, color = Black)
                }
                Spacer(modifier = Modifier.height(8.dp))


            }

        }


    }
}


