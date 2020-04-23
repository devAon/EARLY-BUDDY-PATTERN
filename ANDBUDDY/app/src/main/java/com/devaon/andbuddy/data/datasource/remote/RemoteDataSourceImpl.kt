package com.devaon.andbuddy.data.datasource.remote

import com.devaon.andbuddy.data.datasource.model.PlaceResponse
import com.devaon.andbuddy.data.datasource.remote.retrofit.AndBuddyServiceImpl
import com.google.gson.JsonObject
import io.reactivex.Observable

class RemoteDataSourceImpl : RemoteDataSource {
   val api = AndBuddyServiceImpl.service

    override fun signUp(body: JsonObject) = api.postSignupUser(body).map{it}

    override fun getAddress(addr: String): Observable<PlaceResponse> {
        return api.getAddress(addr).map { it }
    }


}