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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.madhan.feature_tinder.R
import com.madhan.feature_tinder.composable.BottomButtonRow

@Composable
fun TinderDisplayScreen06(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column {
            // Image
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Text(
                        text = "Emily,"
                    )
                    Text(
                        text = "23"
                    )

                }
                Row {
                    Text(
                        text = "3"
                    )
                    Icon(
                        painter = painterResource(R.drawable.ic_picture),
                        contentDescription = ""
                    )
                }
            }
        }
        BottomButtonRow()
    }
}

@Preview(showBackground = true)
@Composable
fun TinderDisplayScreen06Preview() {
    TinderDisplayScreen06()
}

