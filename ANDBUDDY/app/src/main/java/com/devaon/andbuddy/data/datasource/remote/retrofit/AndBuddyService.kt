package com.devaon.andbuddy.data.datasource.remote.retrofit

import com.devaon.andbuddy.data.datasource.model.PostSignupData
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AndBuddyService {
    @POST("/users/signup")
    fun postSignupUser(
        @Body() body: JsonObject
    ): Observable<PostSignupData>
}