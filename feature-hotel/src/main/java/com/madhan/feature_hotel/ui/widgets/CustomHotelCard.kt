package com.madhan.feature_hotel.ui.widgets

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madhan.feature_hotel.R
import com.madhan.feature_hotel.utils.customColors

@Composable
fun CustomHotelCard(
    modifier: Modifier = Modifier,
    backgroundImage: Painter,
    hotelType: String,
    hotelLocation: String,
    hotelRating: String,
    hotelDistance: String,
    hotelPrice: String,
    isSelected: MutableState<Boolean> // For like button functionality
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = customColors.cardColor,
            contentColor = customColors.hotelTextColor
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Background image
            Image(
                painter = backgroundImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().height(136.dp)
            )

            // Like Icon
            IconButton(
                modifier = Modifier.align(Alignment.TopEnd),
                onClick = { isSelected.value = !isSelected.value },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                )
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(if (isSelected.value) R.drawable.heartfill else R.drawable.heart),
                    contentDescription = "like icon",
                    tint = Color.White
                )
            }

            // Texts placed inside the Box, aligned to the bottom
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(10.dp)
            ) {
                CustomTitleText(
                    text = hotelType,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start
                )
                Spacer(Modifier.height(4.dp))
                CustomTitleText(
                    text = hotelLocation,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Start
                )

                // Divider
                HorizontalDivider(thickness = 0.5.dp, color = Color.LightGray)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Rating
                    IconTextRow(
                        icon = painterResource(R.drawable.rate),
                        text = hotelRating,
                        iconTint = customColors.orange
                    )
                    // Distance
                    IconTextRow(
                        icon = painterResource(R.drawable.nav),
                        text = hotelDistance,
                        iconTint = customColors.descriptionColor
                    )
                    // Price
                    IconTextRow(
                        icon = painterResource(R.drawable.moon),
                        text = hotelPrice,
                        iconTint = customColors.descriptionColor
                    )
                }
            }
        }
    }
}
