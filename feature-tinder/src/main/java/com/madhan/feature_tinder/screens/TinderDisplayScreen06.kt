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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.madhan.feature_tinder.R
import com.madhan.feature_tinder.TinderRoute
import com.madhan.feature_tinder.composable.BottomButtonRow
import com.madhan.feature_tinder.composable.ImageCard
import com.madhan.feature_tinder.composable.TopBar
import com.madhan.feature_tinder.viewmodel.ProfileViewModel

// DISPLAY SCREEN IS A MAJOR STATE HOLDER

@Composable
fun TinderDisplayScreen06(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    viewModel: ProfileViewModel
) {
    val profiles = viewModel.profiles.observeAsState(listOf()).value
    val currentProfileIndex = viewModel.currentProfileIndex.observeAsState(
        viewModel.currentProfileIndex.value ?: 0
    ).value
    val profile = profiles[currentProfileIndex]

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            TopBar(
                leftSlot = {
                    Icon(
                        painter = painterResource(R.drawable.ic_home),
                        contentDescription = "",
                        modifier = Modifier
                            .clickable {
                                navController!!.navigate(TinderRoute.ProfileScreen.route)
                            }
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
            var color = Color.Transparent
            if (profile.haveRejected) color = Color(0xFF7A1AFF)
            if (profile.haveLiked) color = Color(0x63E2BCFF)
            if (profile.haveSuperLiked) color = Color(0xFFC10EFF)
            ImageCard(
                image = profile.photo,
                name = profile.firstName,
                age = profile.age,
                likes = profile.photoViews,
                color = color
            )
        }
        BottomButtonRow(
            onBack = {
                navController!!.popBackStack()
            },
            onDenyClicked = {
                profiles[currentProfileIndex].apply {
                    viewModel.updateProfile(
                        interacted = true,
                        rejected = true,
                        liked = false,
                        superLiked = false
                    )
                }
            },
            onLikedClicked = {
                profiles[currentProfileIndex].apply {
                    viewModel.updateProfile(
                        interacted = true,
                        rejected = false,
                        liked = true,
                        superLiked = false
                    )
                }
            },
            onSuperLikedClicked = {
                profiles[currentProfileIndex].apply {
                    viewModel.updateProfile(
                        interacted = true,
                        rejected = false,
                        liked = false,
                        superLiked = true
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TinderDisplayScreen06Preview() {
//    TinderDisplayScreen06()
}

