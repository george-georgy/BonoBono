package com.george_georgy.bonobono.feature_meal.presentation.category_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.george_georgy.bonobono.feature_meal.domain.model.Category
import com.george_georgy.bonobono.feature_meal.presentation.ui.theme.ApricotColor


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CategoryGridItem(
    category: Category, onClick: (Category) -> Unit
) {

    Card(
        modifier = Modifier
            .height(120.dp)
            .clickable {
                onClick(category)
            }
            .padding(10.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = ApricotColor),

        ) {
        Column(modifier = Modifier) {
            GlideImage(
                model = category.strCategoryThumb,
                contentDescription = "Grid Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(5.dp)),
                alignment = Alignment.Center
            )
            Text(
                text = category.strCategory,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 8.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black
            )


        }

    }


}