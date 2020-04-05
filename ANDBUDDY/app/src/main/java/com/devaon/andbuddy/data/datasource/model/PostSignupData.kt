package com.devaon.andbuddy.data.datasource.model

import com.google.gson.annotations.SerializedName

data class PostSignupData (
    @SerializedName("status")
    val status: Int,
    @SerializedName("data")
    val idx: Int,
    @SerializedName("message")
    val message: String
)