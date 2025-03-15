package com.madhan.feature_tinder.dummydata

import androidx.annotation.DrawableRes
import java.time.LocalDate
import java.util.Date

data class Profile(
    val photos: List<Photo>,
    val firstName: String,
    val lastName: String,
    val dob: LocalDate,
    val city: String,
    val description: String,
    val milesAway: Int,
    val photoViews: Int
)

data class Photo(
    @DrawableRes val drawable: Int
)