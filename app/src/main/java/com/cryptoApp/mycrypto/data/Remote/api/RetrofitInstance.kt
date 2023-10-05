package com.cryptoApp.mycrypto.data.Remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient{
    private val BASE_URL ="https://api.coingecko.com/api/v3"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService:ApiInterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }
}
