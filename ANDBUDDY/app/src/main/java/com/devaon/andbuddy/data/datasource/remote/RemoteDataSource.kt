package com.devaon.andbuddy.data.datasource.remote

import com.devaon.andbuddy.data.datasource.model.PostSignupData
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.Response

interface RemoteDataSource { //필요한 함수들을 모아서 정의하는 인터페이스
    /*fun signUp(jsonObject: JsonObject, //post에 필요한 값을 보낼 body
               onResponse: (Response<PostSignupData>) -> Unit, //통신 성공시 수행할 함수
               onFailure: (Throwable) -> Unit) //통신 실패시 수행할 함수*/
    fun signUp(jsonObject: JsonObject) : Observable<PostSignupData>
}