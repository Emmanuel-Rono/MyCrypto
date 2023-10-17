package com.cryptoApp.mycrypto.data.Room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.cryptoApp.mycrypto.data.CryptoEntity

@Dao
interface CryptoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun  insertCoins(item: List<CryptoEntity>)
    @Query("SELECT * FROM CryptoListTable")
    suspend fun getAllCoins() : List<CryptoEntity>
    @Update
    suspend fun updateCoin(coin: CryptoEntity)
@Query("Select * from CryptoListTable where isFavourite =1 ")
suspend fun getFavouriteCoins() :LiveData<List<CryptoEntity>>

}