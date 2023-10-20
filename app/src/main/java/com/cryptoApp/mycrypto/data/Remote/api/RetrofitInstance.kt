package com.cryptoApp.mycrypto.data.Remote.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private const val BASE_URL = "https://api.coingecko.com/api/v3/coins/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService: ApiInterface = retrofit.create(ApiInterface::class.java)
}

object ApiClientChart {
    private const val BASE_URL = "https://api.coingecko.com/api/v3/coins/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService: ApiInterface = retrofit.create(ApiInterface::class.java)
}

val logging = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}
val httpClient = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()
