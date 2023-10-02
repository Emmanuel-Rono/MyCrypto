package com.cryptoApp.mycrypto.data.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.cryptoApp.mycrypto.data.CryptoEntity
import retrofit2.http.Query

@Dao
interface CryptoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  InsertCoins(item:List<CryptoEntity>)
    @Query("SELECT * FROM CryptoListTable")
    suspend fun getAllCoins() : List<CryptoEntity>

}