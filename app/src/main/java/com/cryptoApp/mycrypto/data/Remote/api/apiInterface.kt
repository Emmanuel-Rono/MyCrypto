package com.cryptoApp.mycrypto.data.Remote.api

import com.cryptoApp.mycrypto.data.CryptoList
import retrofit2.Retrofit
import retrofit2.http.GET

interface apiInterface {

    @GET("/coins/markets")
    suspend fun getCoinsFromApi():List<CryptoList>

}