package com.cryptoApp.mycrypto.data.Remote.api

import com.cryptoApp.mycrypto.data.CryptoEntity
import com.cryptoApp.mycrypto.data.CryptoList
import com.cryptoApp.mycrypto.data.Remote.model.PriceChartResponse

import retrofit2.http.Query

import retrofit2.http.GET
import retrofit2.http.Path


interface ApiInterface {

   // @GET("/api/v3/coins/markets")
    @GET("markets?vs_currency=eur&order=market_cap_desc&per_page=100&page=1&sparkline=false&locale=en")
    suspend fun getCoinsFromApi(
    ): List<CryptoList>


    @GET("coins/{id}/market_chart")
    suspend fun getMarketChart(
        @Path("id") coinId: String,
        @Query("vs_currency") currency: String = "eur",
        @Query("days") days: Int = 50
    ): PriceChartResponse

}

