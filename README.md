

### 🔥목차🔥

#### 🍓 안드로이드 아키텍처 컴포넌트 (AAC)

#### 🍓 MVC 와 MVVM 차이점

#### 🍓 MVVM 패턴

#### 🍓 MVVM 장점

#### 🐥 실습 - MVVM 패턴, Repository, BataBinding 적용









## 안드로이드 아키텍쳐 컴포넌트 

* 안드로이드 아키텍쳐 컴포넌트(Android Architecture Components, AAC)

* 라이브러리 모음

  + 앱 구조를 더 튼튼하도록

  + 테스트에 용이하도록

  + 유지 보수성이 뛰어나도록

* 모듈화된 코딩을 돕기 위해 `Databinding`, `LiveData`, `ViewModel` 등의 유용한 라이브러리를 제공

  이러한 라이브러리의 모음은 MVVM 패턴의 구조의 설계에 최적화되어 있다.

![image-20200406170208387](C:\Users\choiyewon\AppData\Roaming\Typora\typora-user-images\image-20200406170208387.png)



#### View - 뷰 

- UI Controller를 담당하는 Activity, Fragment이다.

* 화면에 무엇을 그릴지 결정하고, 사용자와 상호작용한다. 
* 데이터의 변화를 감지하기 위한 옵저버를 가지고 있다.

#### ViewModel - 뷰모델

* 뷰모델은 UI를 위한 데이터를 가지고 있다.

* 구성(configuration)이 변경되어도 살아남는다. (예를 들어 화면 회전이라던가, 언어 변경 등) 

* `AsyncTask`는 액티비티나 프래그먼트의 생명 주기에서 자유로울 수 없지만, 

  뷰모델은 뷰와 분리되어 있기 때문에 액티비티가 Destroy 되었다가 다시 Create 되어도 종료되지 않고 데이터를 여전히 가지고 있다.

#### LiveData - 라이브데이터

* 관찰이 가능한(Observable) 데이터 홀더 클래스이다. 
* 뷰에서 뷰모델의 라이브데이터를 관찰하게 되면 데이터가 변경될 때 내부적으로 자동으로 알려주게 된다.
* 액티비티나 프래그먼트의 생명 주기를 인지한다. 즉, 액티비티가 화면 위에 활성화되어 있을 때에만 UI변경 등의 기능을 동작하게 되고, Destroy 된 상태에서는 동작하기 않기 때문에 메모리 릭의 발생을 줄여준다.

#### Repository - 리포지토리

* 뷰모델과 상호작용하기 위해 잘 정리된(Clean) 데이터 API를 들고 있는 클래스이다. 

* 앱에 필요한 데이터 (내장DB or 외부DB) 를 가져온다. 

  뷰모델은 DB나 서버에 직접 접근하지 않고, 리포지토리에 접근하는 것으로 앱의 데이터를 관리한다.

#### Room - 룸

* SQLite 데이터베이스를 편하게 사용하게 해주는 라이브러리이다. 
* SQLite의 코드를 직접 작성하는 경우, 직접 테이블을 Create 하거나 쿼리문을 일일이 변수를 통해 작성해주어야 했지만, Room을 쓰면 조금 더 직관적이고 편리하게 DB를 사용할 수 있다.









## 아키텍처 적용 전의 문제점

액티비티에 기능을 붙이다보면 액티비티가 무거워지거나 혹은 종속성이 너무 강해 

테스트가 힘들고 유지보수가 어려워진다.



## MVVM 패턴

`View - ViewModel - Model` 을 이용해 각각의 역할을 분리하여 

가독성과 재사용성을 높인 디자인 패턴으로 종속성 및 유지보수의 어려움을 해소해준다.



## MVC와 MVVM 차이점

![img](https://k.kakaocdn.net/dn/brppPZ/btqDbEtBEp8/oPJJkr4n9wfGz8NZalCb40/img.png) 

* **MVC**  `(Model - View - Controller) `

  * **Controller**

    Activity 부분에서  View에게는 화면 업데이트,  Model에게는 데이터 갱신을 알리며

    View와 Mdel을 연결해주며 비즈니스 로직을 처리하기 위해 많은 일을 해야한다.

  * **View**

    activity_main.xml 화면 부분으로 UI 역할 담당한다.

  * **Model**

  ​       Model class로 비즈니스 로직에서의 알고리즘, 데이터 드의 기능 처리한다.

  

* **MVVM** `(View - ViewModel - Model)`

  * **View** 

    Activity 역할을 담당하고 UI를 갱신하는 역할에만 충실히 한다.

  ​       뷰모델을 관찰(Observe) 한다. 

  ​       따라서, 데이터의 변화를 알아차리고 자동으로 화면을 갱신할 수 있다.

  * **ViewModel**   

    Model에게 데이터 갱신 처리를 요청하고 잘 정리된 데이터를 참조한다.

  * **Model**

    Repository, DataBase 부분으로 데이터 처리 역할을 한다.

    

## MVVM 장점

**1. 뷰가 데이터를 실시간으로 관찰한다**

LiveData (=Observable 패턴) 을 이용해 DB를 관찰하고 자동으로 UI를 갱신한다. 

직접 뷰를 바꾸어주는 번거로움을 없애고 데이터와 불일치할 확률이 줄인다.

**2. 생명주기로부터 안전하여 메모리 릭을 방지할 수 있다** 

뷰모델을 통해 데이터를 참조하기 때문에 액티비티/프래그먼트의 생명주기를 따르지 않는다.

​	=>  화면전환과 같이 액티비티가 파괴된 후 재구성 되어도 뷰모델이 데이터를 홀드하고 있기 때문에 

​		  영향을 받지 않는다. 

뷰가 활성화되어있을 경우에만 작동하기 때문에 불필요한 메모리 사용을 줄일 수 있다.

**3. 기능별로 모듈화되어 있어 역할 분리를 할 수 있고 유닛 테스트에 한결 용이해진다. **

> - 내장 DB를 통째로 바꾸고 싶다고 할 때, 뷰나 다른 코드에 깊게 종속돼있지 않아 DB 교체가 쉽다.
>
> - 뷰모델과 뷰가 1:n 연결이 가능하다.
>
>   따라서, 뷰모델에 하나의 메소드를 구현해 놓으면 
>
>   A 액티비티든 B 액티비티든 여러 뷰에서 호출해 재사용하기 편리하다.







## 실습 - MVVM 패턴, Repository, BataBinding 적용

 `얼리버디` 프로젝트에 MVVM 아키텍처를 적용해 공부한 내용을 익혔보려 한다.

![img](https://k.kakaocdn.net/dn/dedE2h/btqCNaeBOQV/NH166UH3Rk2fk8x2GEQcOk/img.png)



![image-20200406182920710](C:\Users\choiyewon\AppData\Roaming\Typora\typora-user-images\image-20200406182920710.png)



**SignupActivity.kt**

```
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
    
...

fun communication(id: String, pw: String) {
        var jsonObject = JSONObject()
        jsonObject.put("userId", id)
        jsonObject.put("userPw", pw)


        val body = JsonParser().parse(jsonObject.toString()) as JsonObject
        vm.viewCommunicate(body)
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



```

 

**SignupViewModel.kt**

    class SignupViewModel : ViewModel() {
        val signupRepository = SignupRepository()
    
        internal val disposables = CompositeDisposable()
    
        val isSuccessNetwork = MutableLiveData<Boolean>()
        val wifiDisconnect = MutableLiveData<Unit>()
        
        fun viewCommunicate(jsonObject: JsonObject) {
    
            val body = JsonParser().parse(jsonObject.toString()) as JsonObject
            Log.d("test", "postUserData body : " + body)
    
            signupRepository.signUp(body = body,
                onResponse = {
                    //고차함수로 구현, it으로 response에 바로 접근 가능
                    if (it.isSuccessful) {
                        val intent = Intent(this, SignupSuccessActivity::class.java)
                        startActivity(intent)
                        isSuccessNetwork.value = true
    
                    } else { //아이디 중복
                        isSuccessNetwork.value = false
    
                        Log.d("test", "아이디중복: " + it.message())
                    }
    
                }, onFailure = {
                    //고차함수로 구현, it으로 t에 바로 접근 가능
                    Log.d("test", "통신 실패 error : " + it.toString())
                    wifiDisconnect.value = Unit
                    val intent = Intent(this@SignupActivity, SignupFailActivity::class.java)
                    startActivity(intent)
                }
            )
        }
    }



**SignupRepository.kt**

```
class SignupRepository{
    val retrofitRemoteDataSource: RemoteDataSource = RemoteDataSourceImpl() //인스턴스 생성
    fun signUp(
        jsonObject: JsonObject,
        onResponse: (Response<PostSignupData>) -> Unit,
        onFailure: (Throwable) -> Unit
    ){
        //생성한 인스턴스로 RempteDataSourceImpl에 구현해놓은 함수 실행
        retrofitRemoteDataSource.signUp(jsonObject, onResponse, onFailure)
    }
}
```



**PostSignupData.kt**

```
data class PostSignupData (
    @SerializedName("status")
    val status: Int,
    @SerializedName("data")
    val idx: Int,
    @SerializedName("message")
    val message: String
)
```



**AndBuddyService.kt**

```
interface AndBuddyService {
    @POST("/users/signup")
    fun postSignupUser(
        @Body() body: JsonObject
    ): Call<PostSignupData>
}
```



**AndBuddyServiceImpl.kt**

```
object AndBuddyServiceImpl {
    private const val BASE_URL = "http://서버주소:3456/"

    private val okHttpClient: OkHttpClient =
        OkHttpClient.Builder().addInterceptor(CookiesIntercepter())
            .addNetworkInterceptor(CookiesIntercepter()).build()

    private val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).client(
            okHttpClient
        )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val service: AndBuddyService = retrofit.create(
        AndBuddyService::class.java)
}
```



**RemoteDataSource.kt**

```
interface RemoteDataSource { //필요한 함수들을 모아서 정의하는 인터페이스
    fun signUp(jsonObject: JsonObject, //post에 필요한 값을 보낼 body
               onResponse: (Response<PostSignupData>) -> Unit, //통신 성공시 수행할 함수
               onFailure: (Throwable) -> Unit) //통신 실패시 수행할 함수
}
```



**RetmoteDataSourceImpl.kt**

```
class RemoteDataSourceImpl : RemoteDataSource { //RemoteDataSource를 상속받는 클래스
    override fun signUp(
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
    }
}
```



**build.gradle (Module: app)**

```
android {
	
	...
	
	dataBinding {
        enabled = true
    }

}

dependencies {

	...

	//Retrofit 라이브러리 : https://github.com/square/retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.6.2'
    //Retrofit 라이브러리 응답으로 가짜 객체를 만들기 위해
    implementation 'com.squareup.retrofit2:retrofit-mock:2.6.2'

    //객체 시리얼라이즈를 위한 Gson 라이브러리 : https://github.com/google/gson
    implementation 'com.google.code.gson:gson:2.8.6'
    //Retrofit 에서 Gson 을 사용하기 위한 라이브러리
    implementation 'com.squareup.retrofit2:converter-gson:2.6.2'

    //okHttp
    implementation 'com.squareup.okhttp3:logging-interceptor:3.8.1'
    implementation 'com.squareup.okhttp3:okhttp:3.8.1'

    //리사이클러뷰 라이브러리
    implementation 'androidx.recyclerview:recyclerview:1.1.0-alpha06'
  }
```





**통신을 위한 퍼미션을 주기 위해 2가지를 추가해줘야한다.**

**1) AndroidManifest.xml**

```
 <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
 <uses-permission android:name="android.permission.INTERNET" />
```

<application> 태그 위에 해당 코드를 추가줘야한다.



**CookiesIntercepter.kt**

```
class CookiesIntercepter : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request =
            chain.request().newBuilder().header("Content-Type", "application/json")
                .build()
        return chain.proceed(request)
    }
}
```

