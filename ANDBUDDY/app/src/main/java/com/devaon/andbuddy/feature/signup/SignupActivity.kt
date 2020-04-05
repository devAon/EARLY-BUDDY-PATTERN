package com.devaon.andbuddy.feature.signup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.devaon.andbuddy.R
import com.devaon.andbuddy.data.repository.SignupRepository
import com.devaon.andbuddy.databinding.ActivitySignupBinding
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_signup.*
import org.json.JSONObject

import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {

    val pwdPattern = Pattern.compile("^[a-zA-Z0-9]+$", Pattern.CASE_INSENSITIVE)

    lateinit var id: String
    lateinit var pw: String

    var vm: SignupViewModel = SignupViewModel()


    lateinit var binding : ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_signup)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        makeController()

        binding.signupActivity = this

        addObserverableData()
    }

    private fun makeController() {
        idCheck()
        passwordCheck()

        act_signup_cl_join.setOnClickListener {
            Log.d("test", "눌려따ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ")


            if (id.isEmpty() || pw.isEmpty()) {
                act_signup_cl_join.setBackgroundResource(R.drawable.act_signup_round_rect_gray_full)
                Toast.makeText(this, "아이디와 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                    Log.d("test", "makeController id : " + id)
                    Log.d("test", "makeController pw : " + pw)
                    click()
                    act_signup_cl_join.setBackgroundResource(R.drawable.act_signup_round_rect_blue_full)
                }
            }

        }

    private fun idCheck() {
        act_signup_et_id.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                id = act_signup_et_id.text.toString()

                if (p0!!.length > 0) {
                    act_signup_cl_id.setBackgroundResource(R.drawable.act_signup_round_rect_blue)
                    act_signup_et_id.setTextColor(
                        ContextCompat.getColor(
                            this@SignupActivity,
                            R.color.black
                        )
                    )
                    Log.d("test", "postUserData id : " + id)


                } else {
                    act_signup_cl_join.setBackgroundResource(R.drawable.act_signup_round_rect_gray_full)
                    act_signup_cl_id.setBackgroundResource(R.drawable.act_signup_round_rect_gray)
                    act_signup_et_id.setTextColor(
                        ContextCompat.getColor(
                            this@SignupActivity,
                            R.color.light_gray
                        )
                    )
                }
            }

        })
    }


    private fun passwordCheck() {
        act_signup_et_pw.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                pw = act_signup_et_pw.text.toString()

                if (p0!!.length > 0) {
                    act_signup_cl_pw.setBackgroundResource(R.drawable.act_signup_round_rect_blue)
                    act_signup_et_pw.setTextColor(
                        ContextCompat.getColor(
                            this@SignupActivity,
                            R.color.black
                        )
                    )
                    Log.d("test", "postUserData pw : " + pw)

                } else {
                    act_signup_cl_pw.setBackgroundResource(R.drawable.act_signup_round_rect_red)
                    act_signup_et_pw.setTextColor(
                        ContextCompat.getColor(
                            this@SignupActivity,
                            R.color.black
                        )
                    )
                }
            }
        })


    }

    fun communication(id: String, pw: String) {

        var jsonObject = JSONObject()
        jsonObject.put("userId", id)
        jsonObject.put("userPw", pw)


        val body = JsonParser().parse(jsonObject.toString()) as JsonObject
        vm.viewCommunicate(body)


        /*val signUpRepository = SignupRepository()

    val body = JsonParser().parse(jsonObject.toString()) as JsonObject
    Log.d("test", "postUserData body : " + body)

    signUpRepository.signUp(jsonObject = body,
        onResponse = { //고차함수로 구현, it으로 response에 바로 접근 가능
            if (it.isSuccessful){
                val intent = Intent(this@SignupActivity, SignupSuccessActivity::class.java)
                ContextCompat.startActivity(intent)
            }else
                Log.d("test",  "postUserData 응답 실패 : " + it.message())
        }, onFailure = { //고차함수로 구현, it으로 t에 바로 접근 가능

            Log.d("test",  "통신 실패 error : " + it.toString())
            val intent = Intent(this@SignupActivity, SignupFailActivity::class.java)
            ContextCompat.startActivity(intent)
        }
    )*/


    }

     fun click() {
         communication(id, pw)
    }

    private fun View.showOrInvisible(show: Boolean) {
        visibility = if (show) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }



    private fun idDuplicate(){
        act_signup_tv_id_ment.showOrInvisible(true)

    }

    private fun addObserverableData(){
        vm.isSuccessNetwork.observe(
            this, Observer {
                if(it){
                    val intent = Intent(this@SignupActivity, SignupSuccessActivity::class.java)
                    startActivity(intent)
                }else{
                    idDuplicate()
                }
                }
        )

        vm.wifiDisconnect.observe(
            this, Observer {
                val intent = Intent(this@SignupActivity, SignupFailActivity::class.java)
                startActivity(intent)
            }
        )
    }

}
