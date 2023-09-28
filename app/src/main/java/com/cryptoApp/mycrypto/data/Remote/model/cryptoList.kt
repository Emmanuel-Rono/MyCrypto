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
    val current_price: Int,
    val fully_diluted_valuation: Long,
    val high_24h: Int,
    val id: String,
    val image: String,
    val last_updated: String,
    val low_24h: Int,
    val market_cap: Long,
    val market_cap_change_24h: Int,
    val market_cap_change_percentage_24h: Double,
    val market_cap_rank: Int,
    val max_supply: Int,
    val name: String,
    val price_change_24h: Double,
    val price_change_percentage_24h: Double,
    val roi: Any,
    val symbol: String,
    val total_supply: Int,
    val total_volume: Long
)
@Entity(tableName = "CryptoListTable")
data class CryptoEntity(
   @PrimaryKey val id: String,
    val name: String,
    val price: Double?,
    val changePercent: Double? = null,
    val image: String? = null,
    val isFavourite: Boolean = false
)