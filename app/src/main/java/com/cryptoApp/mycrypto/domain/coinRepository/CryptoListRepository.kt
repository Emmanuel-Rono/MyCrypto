package com.cryptoApp.mycrypto.domain

import com.cryptoApp.mycrypto.data.CryptoEntity

class CryptoListRepository (
    private val LocalDataSource: CryptoLocalDataSource,
    private val RemoteDataSource: CryptoRemoteDataSource
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