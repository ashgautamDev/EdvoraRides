package com.ashish.edvorarides.data.api

import com.ashish.edvorarides.data.model.User
import retrofit2.http.GET

interface EdvoraApi {

    @GET("/user")
    suspend fun getUser() : User

}