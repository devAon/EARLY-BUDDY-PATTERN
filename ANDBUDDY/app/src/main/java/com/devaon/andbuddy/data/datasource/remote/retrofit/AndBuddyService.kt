package com.devaon.andbuddy.data.datasource.remote.retrofit

import com.devaon.andbuddy.data.datasource.model.UserResponse
import com.devaon.andbuddy.data.datasource.model.PlaceResponse
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.*


interface AndBuddyService {
    @POST("/users/signup")
    fun postSignupUser(
        @Body() body: JsonObject
    ): Observable<UserResponse>

    @GET("/searchAddress")
    fun getAddress(
        @Query("addr") addr: String
    ): Observable<PlaceResponse>


}