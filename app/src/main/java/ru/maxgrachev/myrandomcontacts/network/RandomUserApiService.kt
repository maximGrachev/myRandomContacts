package ru.maxgrachev.myrandomcontacts.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://randomuser.me/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface RandomUserApiService{
    @GET("api/?results=500")
    suspend fun getProperties(): RandomUserProperty
}

object RandomUserApi{
    val retrofitSevice: RandomUserApiService by lazy{
        retrofit.create(RandomUserApiService::class.java)
    }
}