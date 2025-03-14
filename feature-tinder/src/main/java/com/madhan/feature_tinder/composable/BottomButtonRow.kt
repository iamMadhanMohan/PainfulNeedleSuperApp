package com.madhan.feature_tinder.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.madhan.feature_tinder.R
import com.madhan.feature_tinder.screens.BottomButton

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