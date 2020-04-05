package com.devaon.andbuddy.data.repository

import com.devaon.andbuddy.data.datasource.model.PostSignupData
import com.devaon.andbuddy.data.datasource.remote.RemoteDataSource
import com.devaon.andbuddy.data.datasource.remote.RemoteDataSourceImpl
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.Response

class SignupRepository{
    val signupRemoteDataSource: RemoteDataSource = RemoteDataSourceImpl() //인스턴스 생성
    /*fun signUp(
        jsonObject: JsonObject,
        onResponse: (Response<PostSignupData>) -> Unit,
        onFailure: (Throwable) -> Unit
    ){
        //생성한 인스턴스로 RempteDataSourceImpl에 구현해놓은 함수 실행
        retrofitRemoteDataSource.signUp(jsonObject, onResponse, onFailure)
    }*/

    fun signUp( body: JsonObject ) : Observable<PostSignupData> =
        signupRemoteDataSource.signUp(body)

}