package com.madhan.feature_tinder.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.madhan.feature_tinder.R

@Composable
fun TinderScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.img_tinder_screen_00),
            contentDescription = ""
        )
        Text(
            text = "Meet"
        )
        Text(
            text = "lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis sit amet odio in egestas. Pellen tesque ultricies justo."
        )
        Button(
            onClick = {}
        ) {
            Text(
                text = "Let's go"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TinderScreenPreview() {
    TinderScreen()
}