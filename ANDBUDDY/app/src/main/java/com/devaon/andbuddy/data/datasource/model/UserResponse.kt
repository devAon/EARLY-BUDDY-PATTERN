package com.devaon.andbuddy.data.datasource.model

import com.google.gson.annotations.SerializedName

data class UserResponse (
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val idx: Int
)