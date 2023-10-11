package com.cryptoApp.mycrypto.domain.coinRepository

import com.cryptoApp.mycrypto.data.CryptoEntity
import com.cryptoApp.mycrypto.data.Remote.api.ApiClient
import com.cryptoApp.mycrypto.data.Room.CryptoDao


class CryptoListRepository(
    private val LocalDataSource: CryptoLocalDataSource,
    private val RemoteDataSource: CryptoRemoteDataSource,
    private val dao:CryptoDao
) {
    suspend fun getCoinList(): List<CryptoEntity> {
        return LocalDataSource.getCryptoCoinListFromRoom()
    }

    suspend fun refreshCoin() {
        RemoteDataSource.getRemoteCrypto()
    }
    suspend fun updateCoin(coin: CryptoEntity) {
        dao.updateCoin(coin)
    }


}
