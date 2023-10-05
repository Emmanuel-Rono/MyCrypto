package com.cryptoApp.mycrypto.domain.coinRepository

import com.cryptoApp.mycrypto.data.Remote.api.ApiInterface
import com.cryptoApp.mycrypto.data.Room.CryptoDao

class CryptoRemoteDataSource(private val cryptoDao: CryptoDao, private val api: ApiInterface) {

    suspend fun getRemoteCrypto() {
        val cryptoFromRemote=api.getCoinsFromApi()
        val cryptoList =cryptoFromRemote.map { it.toCryptoEntity() }
        cryptoDao.insertCoins(cryptoList)
    }
}