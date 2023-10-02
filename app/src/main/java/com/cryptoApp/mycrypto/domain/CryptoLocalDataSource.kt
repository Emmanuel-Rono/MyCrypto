package com.cryptoApp.mycrypto.domain

import com.cryptoApp.mycrypto.data.CryptoEntity
import com.cryptoApp.mycrypto.data.Remote.api.apiInterface
import com.cryptoApp.mycrypto.data.Room.CryptoDao

abstract class CryptoLocalDataSource(private val cryptoDao:CryptoDao, private val api:apiInterface): List<CryptoEntity> {

    suspend fun getCryptoCoinListFromRoom():List<CryptoEntity>
    {
        val cachedCryptoList=cryptoDao.getAllCoins()
        if (cachedCryptoList.isEmpty()){
            cryptoRemoteDataSource.
        }
    }
}