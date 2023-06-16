package com.george_georgy.bonobono.feature_meal.presentation.favorite_list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.george_georgy.bonobono.feature_meal.data.local.entity.Meal
import com.george_georgy.bonobono.feature_meal.presentation.ui.theme.ApricotColor


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FavoriteMealListItem(
    favoriteMealViewModel: FavoriteMealViewModel = hiltViewModel(),
    meal: Meal,
    onClick: (Meal) -> Unit
) {

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { onClick(meal) },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = ApricotColor),

        ) {
        Row(modifier = Modifier) {
            GlideImage(
                model = meal.strMealThumb,
                contentDescription = "",
                modifier = Modifier
                    .weight(25f)
                    .padding(8.dp)
                    .size(84.dp)
                    .align(Alignment.CenterVertically)
                    .clip(RoundedCornerShape(16.dp))
            )
            Spacer(modifier = Modifier.padding(3.dp))
            Text(
                text = meal.strMeal,
                modifier = Modifier
                    .weight(50f)
                    .align(Alignment.CenterVertically),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black


            )
            Spacer(modifier = Modifier.padding(1.dp))

            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete",

                Modifier
                    .size(25.dp)
                    .weight(25f)
                    .clickable {
                        favoriteMealViewModel.deleteMeal(meal)
                    }
                    .align(Alignment.CenterVertically), tint = Color.Black

            )


        }

    }


}