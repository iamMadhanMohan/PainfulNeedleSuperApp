package com.madhan.feature_tinder.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.madhan.feature_tinder.R
import com.madhan.feature_tinder.composable.BottomButtonRow
import com.madhan.feature_tinder.composable.ImageCard
import com.madhan.feature_tinder.composable.TopBar

// DISPLAY SCREEN IS A MAJOR STATE HOLDER

@Composable
fun TinderDisplayScreen06(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        TopBar(
            leftSlot = {
                Icon(
                    painter = painterResource(R.drawable.ic_home),
                    contentDescription = "",
                    modifier = Modifier
                        .size(32.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            middleSlot = {
                Icon(
                    painter = painterResource(R.drawable.ic_chat),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            },
            rightSlot = {
                Icon(
                    painter = painterResource(R.drawable.ic_account),
                    contentDescription = "",
                    modifier = Modifier
                        .size(32.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        )
        Column {
            ImageCard(
                image = R.drawable.profile_1,
                name = "Person1",
                age = "123",
                likes = "3"
            )
            BottomButtonRow()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TinderDisplayScreen06Preview() {
    TinderDisplayScreen06()
}

