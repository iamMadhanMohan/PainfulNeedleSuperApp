package com.madhan.feature_tinder.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.madhan.feature_tinder.R

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    name: String = "",
    age: String = "",
    likes: String = "",
    color: Color
) {
    val config = LocalConfiguration.current
    val screenHeight = config.screenHeightDp.dp
    val imageHeight = screenHeight * 0.8f
    Surface(
        shadowElevation = 6.dp,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(16.dp)
            .background(color)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "",
                modifier = Modifier
                    .height(imageHeight * 0.9f)
                    .clip(RoundedCornerShape(16.dp)),
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "$name, $age",
                    style = MaterialTheme.typography.titleLarge
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = likes)
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_picture),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }
        }
    }
}