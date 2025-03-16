package com.madhan.feature_tinder

sealed class TinderRoute(val route: String) {
    object TinderScreen: TinderRoute("tinder")
    object PictureChoice: TinderRoute("picture_choice")
    object TakePhoto: TinderRoute("take_photo")
    object AddProfile: TinderRoute("add_profile")
    object EnableLocation: TinderRoute("enable_location")
    object TutorialScreen: TinderRoute("tutorial_screen")
    object TinderDisplayScreen: TinderRoute("tinder_display_screen/{profileId}")
    object ProfileScreen: TinderRoute("profile_screen")
}