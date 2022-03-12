package com.ashish.mygithub.utils

import com.ashish.mygithub.data.api.GithubRepoResponse
import com.ashish.mygithub.data.model.GithubRepo
import com.ashish.mygithub.data.model.branch.Commit


sealed class ViewStateCommits {


    // It Represents different states
    object Empty : ViewStateCommits()
    object Loading : ViewStateCommits()
    data class Success(val result : List<Commit>) : ViewStateCommits()
    data class Error(val exception: Throwable) : ViewStateCommits()
}

sealed class GithubRepoState{
// It Represents different states of starting Screen
object Empty : GithubRepoState() // There is Add Button
object Loading : GithubRepoState() // There is Loading Bar at middle
data class Success(val result : GithubRepoResponse) : GithubRepoState() // at this state we we have a repo card
data class Error(val exception: Throwable) : GithubRepoState() // this state shows the error for Toast message
}
