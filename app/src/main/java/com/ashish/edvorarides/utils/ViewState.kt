package com.ashish.mygithub.utils

import com.ashish.edvorarides.data.api.RidesResponse
import com.ashish.edvorarides.data.model.User


sealed class UserViewState {


    // It Represents different states
    object Empty : UserViewState()
    object Loading : UserViewState()
    data class Success(val user: User) : UserViewState()
    data class Error(val exception: Throwable) : UserViewState()
}

sealed class RidesViewState {
    // It Represents different states of Rides state
    object Empty : RidesViewState() // There is Add Button
    object Loading : RidesViewState() // There is Loading Bar at middle
    data class Success(val allRides : RidesResponse) :
        RidesViewState() // at this state we we have a Rides card

    data class Error(val exception: Throwable) :
        RidesViewState() // this state shows the error for Toast message
}
