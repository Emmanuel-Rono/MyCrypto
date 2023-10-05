package com.cryptoApp.mycrypto.data.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.cryptoApp.mycrypto.data.CryptoEntity
import androidx.room.Query

@Dao
interface CryptoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertCoins(item:List<CryptoEntity>)
    @Query("SELECT * FROM CryptoListTable")
    suspend fun getAllCoins() : List<CryptoEntity>

}