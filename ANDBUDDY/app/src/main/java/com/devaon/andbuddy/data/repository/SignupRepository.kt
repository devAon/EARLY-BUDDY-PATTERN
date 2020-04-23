package com.devaon.andbuddy.data.repository

import com.devaon.andbuddy.data.datasource.model.UserResponse
import com.devaon.andbuddy.data.datasource.remote.RemoteDataSource
import com.devaon.andbuddy.data.datasource.remote.RemoteDataSourceImpl
import com.google.gson.JsonObject
import io.reactivex.Observable

class SignupRepository{
    val signupRemoteDataSource: RemoteDataSource = RemoteDataSourceImpl() //인스턴스 생성

    fun signUp( body: JsonObject ) : Observable<UserResponse> =
        signupRemoteDataSource.signUp(body)

}