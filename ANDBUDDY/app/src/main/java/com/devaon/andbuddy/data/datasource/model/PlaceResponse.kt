package com.devaon.andbuddy.data.datasource.model

import com.google.gson.annotations.SerializedName

data class PlaceResponse (
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("message")
    val message: List<Place>
)

data class Place(
    val placeName :String,
    val addressName: String,
    val roadAddressName: String,
    val x: String,
    val y: String
)
