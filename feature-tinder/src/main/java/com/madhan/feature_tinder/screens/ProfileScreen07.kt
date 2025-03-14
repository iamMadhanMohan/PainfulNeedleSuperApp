package com.madhan.feature_tinder.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.madhan.feature_tinder.R
import com.madhan.feature_tinder.composable.BottomButtonRow

@Composable
fun ProfileScreen07(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
         // Image
        Row {
            Column {
                Row {
                    Text(
                        text = "Emily, "
                    )
                    Text(
                        text = "23"
                    )
                }
                Text(
                    text = "Johannesburg University"
                )
                Text(
                    text = "19 miles away"
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
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        )
        BottomButtonRow()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreen07Preview() {
    ProfileScreen07()
}