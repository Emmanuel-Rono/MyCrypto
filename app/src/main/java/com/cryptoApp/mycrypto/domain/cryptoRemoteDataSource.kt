package com.cryptoApp.mycrypto.domain

import com.cryptoApp.mycrypto.data.CryptoList
import com.cryptoApp.mycrypto.data.Remote.api.apiInterface
import com.cryptoApp.mycrypto.data.Room.CryptoDao

class cryptoRemoteDataSource(private val cryptoDao: CryptoDao, private val api: apiInterface) {

    suspend fun getRemoteCrypto() {
        val cryptoFromRemote=api.getCoinsFromApi()
        val cryptoList =cryptoFromRemote.map { it.toCryptoEntity() }
        cryptoDao.InsertCoins(cryptoList)
    }
}