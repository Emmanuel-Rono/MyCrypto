package com.cryptoApp.mycrypto.data.Remote.api

import com.cryptoApp.mycrypto.data.CryptoList
import retrofit2.http.GET

interface ApiInterface {

    @GET("/coins/markets")
    suspend fun getCoinsFromApi():List<CryptoList>

}