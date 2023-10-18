package com.CryptoApp.mycrypto.presentation.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.cryptoApp.mycrypto.data.Remote.api.ApiClient
import com.cryptoApp.mycrypto.data.Room.CryptoDatabase
import com.cryptoApp.mycrypto.domain.FavaouriteViewModel.favouriteViewModel
import com.cryptoApp.mycrypto.domain.coinRepository.CryptoListRepository
import com.cryptoApp.mycrypto.domain.coinRepository.CryptoLocalDataSource
import com.cryptoApp.mycrypto.domain.coinRepository.CryptoRemoteDataSource
import com.cryptoApp.mycrypto.presentation.Adapter.favouriteAdapter
import com.emmanuel_rono.mycrypto.databinding.FragmentFavouriteCoinsBinding


class FavouriteCoins : Fragment() {
 lateinit var  binding :FragmentFavouriteCoinsBinding
 lateinit var adapter:favouriteAdapter
 lateinit var viewModel: favouriteViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
binding= FragmentFavouriteCoinsBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.favouritesRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 1)
        }
        val coinDatabase = CryptoDatabase.getInstance(requireContext())
        val coinDao = coinDatabase.cryptoDao()
        val api= ApiClient.apiService
        val remoteDataSource = CryptoRemoteDataSource(coinDao,api)
        val localDataSource = CryptoLocalDataSource(coinDao, remoteDataSource)
        val coinRepository = CryptoListRepository(localDataSource,remoteDataSource,coinDao)
        val viewModelFactory =favouriteViewModel.favouriteViewModelFactory(coinRepository,coinDao)
        viewModel = ViewModelProvider(this, viewModelFactory)[favouriteViewModel::class.java]
        adapter=favouriteAdapter(emptyList())
        binding.favouritesRecyclerView.adapter = adapter
        viewModel.favCoin.observe(viewLifecycleOwner) { products ->
            adapter.favCoins= products
            adapter.notifyDataSetChanged()
        }
        viewModel.getFvaCoin()

    }
    }

