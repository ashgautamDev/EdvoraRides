package com.ashish.mygithub.navigation

sealed class Screens(val route : String){

    object NearestScreen : Screens("nearest")
    object UpcomingScreen : Screens("upcoming")
    object PastScreen : Screens("past")
}
