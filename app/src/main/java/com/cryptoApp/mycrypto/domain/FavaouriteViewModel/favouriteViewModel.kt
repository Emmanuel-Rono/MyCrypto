package com.cryptoApp.mycrypto.domain.FavaouriteViewModel

import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.cryptoApp.mycrypto.data.CryptoEntity
import com.cryptoApp.mycrypto.data.Room.CryptoDao
import com.cryptoApp.mycrypto.domain.coinRepository.CryptoListRepository
import com.emmanuel_rono.mycrypto.R
import kotlinx.coroutines.launch

class favouriteViewModel(val repository: CryptoListRepository,val dao: CryptoDao): ViewModel() {
    private val _favCoin = MutableLiveData<List<CryptoEntity>>()
    val favCoin: MutableLiveData<List<CryptoEntity>> get() = _favCoin

    fun getFvaCoin() {
        viewModelScope.launch {
            try {
                val theFavCoin = repository.getFavouriteCoins()
                _favCoin.value = theFavCoin

            }
            catch (e:Exception)
            {
                e.printStackTrace()
            }
        }
    }

class favouriteViewModelFactory(val repository: CryptoListRepository,val dao: CryptoDao): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(favouriteViewModel::class.java)) {
            return favouriteViewModel(repository,dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}}