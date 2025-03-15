package com.madhan.feature_tinder.composable

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.madhan.feature_tinder.R

@Composable
fun BottomButtonRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BottomButton(R.drawable.ic_rewind)
        BottomButton(R.drawable.ic_bigclose)
        BottomButton(R.drawable.ic_fire)
        BottomButton(R.drawable.ic_heart)
        BottomButton(R.drawable.ic_star)
    }
}

@Composable
fun BottomButton(@DrawableRes icon: Int) {
    Surface(
        shape = CircleShape,
        shadowElevation = 6.dp,
    ) {
        Box(
            modifier = Modifier
                .clickable {  }
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = "",
                modifier = Modifier
                    .size(32.dp)
            )
        }
    }
}