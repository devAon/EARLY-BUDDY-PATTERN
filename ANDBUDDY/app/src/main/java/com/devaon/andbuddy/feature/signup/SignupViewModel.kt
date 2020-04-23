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
    private val signupRepository = SignupRepository()

    private val disposables = CompositeDisposable()

    val isSuccessNetwork = MutableLiveData<Boolean>()
    val wifiDisconnect = MutableLiveData<Unit>()

    fun viewCommunicate(body: JsonObject) {
        disposables.add(signupRepository.signUp(body)
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {}
            .doOnTerminate {}
            .subscribe({
                //if (it.isSuccessful){
                    isSuccessNetwork.value = true
                /*}else{ //아이디 중복
                    isSuccessNetwork.value = false
                }*/
            }) {
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

