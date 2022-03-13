package com.ashish.edvorarides.data.model

data class RidesItem(
    val id: Int,
    val origin_station_code: Int,
    val destination_station_code: Int,
    val station_path: List<Int>,
    val date: String,
    val map_url: String,
    val city: String,
    val state: String,
)