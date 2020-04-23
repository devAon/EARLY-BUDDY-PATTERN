package com.devaon.andbuddy.data.repository


import com.devaon.andbuddy.data.datasource.remote.RemoteDataSource
import com.devaon.andbuddy.data.datasource.remote.RemoteDataSourceImpl
import java.util.*

class PlaceSearchRepository {
    val RetrofitRemoteDataSource : RemoteDataSource = RemoteDataSourceImpl()

    fun getAddress(addr: String) = RetrofitRemoteDataSource.getAddress(addr)

}