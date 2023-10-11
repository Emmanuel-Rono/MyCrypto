package com.cryptoApp.mycrypto.domain.coinRepository

import android.util.Log
import com.cryptoApp.mycrypto.data.CryptoEntity
import com.cryptoApp.mycrypto.data.Room.CryptoDao

class CryptoLocalDataSource (private val cryptoDao:CryptoDao, private val remoteDataSource: CryptoRemoteDataSource,
 )
{
    suspend fun getCryptoCoinListFromRoom(): List<CryptoEntity> {
        val cachedCryptoList = cryptoDao.getAllCoins()
        Log.d("Coins Local Received","$cachedCryptoList")
        if (cachedCryptoList.isEmpty()) {
            remoteDataSource.getRemoteCrypto()
            return cryptoDao.getAllCoins()
        }
        return cachedCryptoList
    }

}
