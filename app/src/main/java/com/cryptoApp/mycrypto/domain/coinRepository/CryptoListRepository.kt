package com.cryptoApp.mycrypto.domain.coinRepository

import com.cryptoApp.mycrypto.data.CryptoEntity
import com.cryptoApp.mycrypto.data.Remote.api.ApiClient


class CryptoListRepository(
    private val LocalDataSource: CryptoLocalDataSource,
    private val RemoteDataSource: CryptoRemoteDataSource
) {
    suspend fun getCoinList(): List<CryptoEntity> {
        return LocalDataSource.getCryptoCoinListFromRoom()
    }

    suspend fun refreshCoin() {
        RemoteDataSource.getRemoteCrypto()
    }
}
