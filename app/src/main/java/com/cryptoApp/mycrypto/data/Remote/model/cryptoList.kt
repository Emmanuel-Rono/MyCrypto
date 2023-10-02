package com.cryptoApp.mycrypto.data

import androidx.room.Entity
import androidx.room.PrimaryKey

data class CryptoList(
    val ath: Int,
    val ath_change_percentage: Double,
    val ath_date: String,
    val atl: Double,
    val atl_change_percentage: Double,
    val atl_date: String,
    val circulating_supply: Int,
    val current_price: Double,
    val id: String,
    val image: String,
    val last_updated: String,
    val market_cap_change_percentage_24h: Double,
    val name: String,
    val price_change_24h: Double,
    val price_change_percentage_24h: Double,
    val roi: Any,
    val symbol: String,

)
{
    fun toCryptoEntity():CryptoEntity{
        return CryptoEntity(name,current_price, price_change_percentage_24h,image )
    }
}

@Entity(tableName = "CryptoListTable")
data class CryptoEntity(
    @PrimaryKey val id: String,
    val name: Double,
    val current_price:Double?=null,
    val changePercent: String = null,
    val image: String? = null,
    val isFavourite: Boolean = false
)