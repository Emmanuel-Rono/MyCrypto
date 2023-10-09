package com.cryptoApp.mycrypto.data

import androidx.room.Entity
import androidx.room.PrimaryKey

data class CryptoList(
    val ath_change_percentage: Double,
    val ath_date: String,
    val atl: Double,
    val atl_change_percentage: Double,
    val atl_date: String,
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
        return CryptoEntity(id, name = name, current_price = current_price, changePercent = price_change_percentage_24h, image = image, symbol = symbol)
    }

}
@Entity(tableName = "CryptoListTable")
data class CryptoEntity(
    @PrimaryKey val id: String,
    val name: String,
    val current_price:Double?=null,
    val changePercent: Double? = null,
    val image: String? = null,
    val symbol: String? = null,
    val isFavourite: Boolean = false
)