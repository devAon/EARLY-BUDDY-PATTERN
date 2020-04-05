package com.devaon.andbuddy.feature.signup

import android.content.Intent
import android.util.Log
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devaon.andbuddy.data.repository.SignupRepository
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class SignupViewModel : ViewModel() {
    val signupRepository = SignupRepository()

    internal val disposables = CompositeDisposable()

    val isSuccessNetwork = MutableLiveData<Boolean>()
    val wifiDisconnect = MutableLiveData<Unit>()

    fun viewCommunicate(body: JsonObject) {
        disposables.add(signupRepository.signUp(body)
            .observeOn(AndroidSchedulers.mainThread())
            // 구독할 때 수행할 작업을 구현
            .doOnSubscribe {}
            // 스트림이 종료될 때 수행할 작업을 구현
            .doOnTerminate {}
            // 옵서버블을 구독
            .subscribe({
                // API를 통해 액세스 토큰을 정상적으로 받았을 때 처리할 작업을 구현
                // 작업 중 오류가 발생하면 이 블록은 호출되지 x

                // onResponse

                //if (it.isSuccessful){
                    isSuccessNetwork.value = true

                /*}else{ //아이디 중복
                    isSuccessNetwork.value = false

                    Log.d("test",  "아이디중복: " + it.message())
                }*/

            }) {
                // 에러 블록
                // 네트워크 오류나 데이터 처리 오류 등
                // 작업이 정상적으로 완료되지 않았을 때 호출


                // onFailure
                Log.d("test",  "통신 실패 error : " + it.toString())
                wifiDisconnect.value = Unit
            })
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}


     /*fun viewCommunicate(jsonObject: JsonObject){

        val body = JsonParser().parse(jsonObject.toString()) as JsonObject
        Log.d("test", "postUserData body : " + body)

        signupRepository.signUp(jsonObject = body,
            onResponse = { //고차함수로 구현, it으로 response에 바로 접근 가능
                if (it.isSuccessful){
                    *//*val intent = Intent(this, SignupSuccessActivity::class.java)
                    startActivity(intent)*//*
                    isSuccessNetwork.value = true

                }else{ //아이디 중복
                    isSuccessNetwork.value = false

                    Log.d("test",  "아이디중복: " + it.message())
                }

            }, onFailure = { //고차함수로 구현, it으로 t에 바로 접근 가능
                Log.d("test",  "통신 실패 error : " + it.toString())
                wifiDisconnect.value = Unit
                *//*val intent = Intent(this@SignupActivity, SignupFailActivity::class.java)
                startActivity(intent)*//*
            }
        )
    }*/
