package com.cryptoApp.mycrypto.domain.CoinViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.cryptoApp.mycrypto.data.CryptoEntity
import com.cryptoApp.mycrypto.data.Remote.api.ApiClient
import com.cryptoApp.mycrypto.domain.coinRepository.CryptoListRepository
import kotlinx.coroutines.launch

class CryptoViewModel(private val repository: CryptoListRepository): ViewModel() {
    val _cryptocoinList = MutableLiveData<List<CryptoEntity>>()
    val cryptoCoinList: MutableLiveData<List<CryptoEntity>> get() = _cryptocoinList

    fun getTheCoinList() {
        viewModelScope.launch {
            try {
                val coinList=repository.getCoinList()
                _cryptocoinList.value=coinList

            }
            catch (e:Exception)
            {
                e.printStackTrace()
            }
        }
    }

    fun updateCoin(coin: CryptoEntity) = viewModelScope.launch {
        repository.updateCoin(coin)
    }

    //ViewModelFactory
    class CryptoViewModelFactory(val repository: CryptoListRepository):ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CryptoViewModel::class.java)) {
                return CryptoViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}