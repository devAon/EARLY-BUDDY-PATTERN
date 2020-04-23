package com.devaon.andbuddy.data.datasource.remote

import com.devaon.andbuddy.data.datasource.model.UserResponse
import com.devaon.andbuddy.data.datasource.model.PlaceResponse
import com.google.gson.JsonObject
import io.reactivex.Observable

interface RemoteDataSource {
    fun signUp(jsonObject: JsonObject) : Observable<UserResponse>

    fun getAddress(addr: String) : Observable<PlaceResponse>
}