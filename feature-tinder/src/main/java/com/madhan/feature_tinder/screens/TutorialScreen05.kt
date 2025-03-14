package com.madhan.feature_tinder.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.madhan.feature_tinder.R

@Composable
fun TutorialScreen05(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.img_tinder_screen_05),
            contentDescription = ""
        )
        Text(
            text = "Tutorial"
        )
        Row {
            Icon(
                painter = painterResource(R.drawable.ic_rewind),
                contentDescription = ""
            )
            Text(
                text = "Return to profile"
            )
        }
        Row {
            Icon(
                painter = painterResource(R.drawable.ic_bigclose),
                contentDescription = ""
            )
            Text(
                text = "Return to profile"
            )
        }
        Row {
            Icon(
                painter = painterResource(R.drawable.ic_heart),
                contentDescription = ""
            )
            Text(
                text = "Return to profile"
            )
        }
        Row {
            Icon(
                painter = painterResource(R.drawable.ic_star),
                contentDescription = ""
            )
            Text(
                text = "Return to profile"
            )
        }
        Row {
            Icon(
                painter = painterResource(R.drawable.ic_fire),
                contentDescription = ""
            )
            Text(
                text = "Return to profile"
            )
        }
        Button(
            onClick = {}
        ) {
            Text(
                text = "Discover the profiles"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TutorialScreen05Review() {
    TutorialScreen05()
}