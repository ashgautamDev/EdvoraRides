package com.ashish.edvorarides.data.model

import com.ashish.edvorarides.components.RideCard
import com.google.gson.annotations.SerializedName

data class Rides(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("origin_station_code") var origin_station_code: Int? = null,
    @SerializedName("station_path") var destination_station_code: Int? = null,
    @SerializedName("destination_station_code") var station_path: ArrayList<Int> = arrayListOf(),
    @SerializedName("date") var date: String? = null,
    @SerializedName("map_url") var map_url: String? = null,
    @SerializedName("state") var city: String? = null,
    @SerializedName("city") var state: String? = null,
){
    companion object{
        fun fakeRide() : Rides{
           return Rides(
                id = 2 , 3 ,4 , arrayListOf(4,5,7,8) , "23/04/22" , "" ,"kashipur" , "Uttarakhand"
            )
        }
    }
}