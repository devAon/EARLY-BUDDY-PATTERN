package com.devaon.andbuddy.data.datasource.remote

import com.devaon.andbuddy.data.datasource.model.PostSignupData
import com.devaon.andbuddy.data.datasource.remote.retrofit.AndBuddyServiceImpl
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSourceImpl : RemoteDataSource { //RemoteDataSource를 상속받는 클래스
   val api = AndBuddyServiceImpl.service

    /*override fun signUp(
        jsonObject: JsonObject,
        onResponse: (Response<PostSignupData>) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        AndBuddyServiceImpl.service.postSignupUser(jsonObject).enqueue(object : //enqueue 함수 실행
            Callback<PostSignupData> {
            override fun onFailure(call: Call<PostSignupData>, t: Throwable) { //통신 실패시 실행되는 함수 구현
                onFailure(t)
            }

            override fun onResponse( //통신 성공시 실행되는 함수 구현
                call: Call<PostSignupData>,
                response: Response<PostSignupData>
            ) {
                onResponse(response)
            }
        })
    }*/
    override fun signUp(body: JsonObject) = api.postSignupUser(body).map{it}


}