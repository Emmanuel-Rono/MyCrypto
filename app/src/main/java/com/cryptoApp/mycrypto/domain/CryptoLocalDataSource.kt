package com.cryptoApp.mycrypto.domain

import com.cryptoApp.mycrypto.data.CryptoEntity
import com.cryptoApp.mycrypto.data.Remote.api.apiInterface
import com.cryptoApp.mycrypto.data.Room.CryptoDao

abstract class CryptoLocalDataSource(private val cryptoDao:CryptoDao, private val remoteDataSource: cryptoRemoteDataSource): List<CryptoEntity> {
    suspend fun getCryptoCoinListFromRoom(): List<CryptoEntity> {
        val cachedCryptoList = cryptoDao.getAllCoins()
        if (cachedCryptoList.isEmpty()) {
            remoteDataSource.getRemoteCrypto()
            return cryptoDao.getAllCoins()
        }
        return cachedCryptoList
    }
}
