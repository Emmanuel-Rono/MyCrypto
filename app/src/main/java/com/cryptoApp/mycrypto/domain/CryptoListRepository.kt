package com.cryptoApp.mycrypto.domain

import com.cryptoApp.mycrypto.data.CryptoEntity
import com.cryptoApp.mycrypto.data.Remote.api.apiInterface
import com.cryptoApp.mycrypto.data.Room.CryptoDao

class CryptoListRepository (val dao:CryptoDao, private val api:apiInterface){


}