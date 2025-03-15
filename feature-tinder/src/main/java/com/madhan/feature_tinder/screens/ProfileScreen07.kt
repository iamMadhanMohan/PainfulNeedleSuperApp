package com.madhan.feature_tinder.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.madhan.feature_tinder.R
import com.madhan.feature_tinder.composable.BottomButtonRow
import com.madhan.feature_tinder.composable.TopBar

@Composable
fun ProfileScreen07(
    modifier: Modifier = Modifier
) {
    Column {
        TopBar(
            leftSlot = {
                Icon(
                    painter = painterResource(R.drawable.ic_return),
                    contentDescription = "",
                    modifier = Modifier
                        .scale(2f)
                        .size(32.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        )
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box {
                Image(
                    painter =  painterResource(R.drawable.profile_1),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f/1f),
                    contentScale = ContentScale.FillWidth
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Row {
                        Text(
                            text = "Emily, 23",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                    Text(
                        text = "Johannesburg University",
                        color = Color(0x00000000).copy(alpha = 0.3f)
                    )
                    Text(
                        text = "19 miles away",
                        color = Color(0x00000000).copy(alpha = 0.3f)
                    )
                }
                Row {
                    Text(
                        text = "3"
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_picture),
                        contentDescription = "",
                        modifier = Modifier
                            .size(18.dp)
                    )
                }
            }
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                color = Color(0x00000000).copy(alpha = 0.3f)
            )
            BottomButtonRow()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreen07Preview() {
    ProfileScreen07()
}