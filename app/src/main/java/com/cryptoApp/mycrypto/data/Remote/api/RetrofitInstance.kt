package com.cryptoApp.mycrypto.data.Remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private const val BASE_URL = "https://api.coingecko.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService: ApiInterface = retrofit.create(ApiInterface::class.java)
}
