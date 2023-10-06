package com.cryptoApp.mycrypto.data.Remote.api

import com.cryptoApp.mycrypto.data.CryptoEntity
import com.cryptoApp.mycrypto.data.CryptoList

import retrofit2.http.Query

import retrofit2.http.GET


interface ApiInterface {

    @GET("/api/v3/coins/markets")
    suspend fun getCoinsFromApi(
        @Query("vs_currency") currency: String,
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") perPage: Int = 100,
        @Query("page") page: Int = 1,
        @Query("sparkline") sparkline: Boolean = false,
        @Query("locale") locale: String = "en"
    ): List<CryptoList>
}

