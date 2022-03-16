package com.ashish.edvorarides.data.model

data class User(
    val name: String,
    val station_code: Int,
    val url: String
){
    companion object{
        val fakeUser = User(
            "Ashish Gautam",
            20,
            "https://avatars.githubusercontent.com/u/56464485?v=4"
        )
    }
}