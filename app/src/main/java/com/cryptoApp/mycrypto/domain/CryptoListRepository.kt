package com.cryptoApp.mycrypto.domain

import com.cryptoApp.mycrypto.data.CryptoEntity
import com.cryptoApp.mycrypto.data.Remote.api.apiInterface
import com.cryptoApp.mycrypto.data.Room.CryptoDao

class CryptoListRepository (
    private val LocalDataSource: CryptoLocalDataSource,
    private val RemoteDataSource: cryptoRemoteDataSource
        )

{
    suspend fun getCoinList():List<CryptoEntity>
    {
        return LocalDataSource.getCryptoCoinListFromRoom()
    }
    suspend fun refreshCoin()
    {
        RemoteDataSource.getRemoteCrypto()
    }


}