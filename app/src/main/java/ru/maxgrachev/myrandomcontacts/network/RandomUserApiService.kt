package ru.maxgrachev.myrandomcontacts.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://randomuser.me/"
//https://randomuser.me/api/?results=5000

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface RandomUserApiService{
    @GET("api/?results=50&inc=name,phone,email,picture")
    fun getProperties(): Call<String>
}

object RandomUserApi{
    val retrofitSevice: RandomUserApiService by lazy{
        retrofit.create(RandomUserApiService::class.java)
    }
}