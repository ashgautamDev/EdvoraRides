package com.ashish.mygithub.utils

import com.ashish.edvorarides.data.api.RidesResponse
import com.ashish.edvorarides.data.model.User


sealed class UserViewState {


    // It Represents different states
    object Empty : UserViewState()
    object Loading : UserViewState()
    data class Success(val result: User) : UserViewState()
    data class Error(val exception: Throwable) : UserViewState()
}

sealed class EdvoraViewState {
    // It Represents different states of Rides state
    object Empty : EdvoraViewState() // There is Add Button
    object Loading : EdvoraViewState() // There is Loading Bar at middle
    data class Success(val result: RidesResponse) :
        EdvoraViewState() // at this state we we have a Rides card

    data class Error(val exception: Throwable) :
        EdvoraViewState() // this state shows the error for Toast message
}
