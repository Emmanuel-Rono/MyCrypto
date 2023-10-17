package com.CryptoApp.mycrypto.presentation.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.cryptoApp.mycrypto.presentation.Adapter.favouriteAdapter
import com.emmanuel_rono.mycrypto.R
import com.emmanuel_rono.mycrypto.databinding.FragmentFavouriteCoinsBinding


class FavouriteCoins : Fragment() {
 lateinit var  binding :FragmentFavouriteCoinsBinding
 lateinit var recyclerView:RecyclerView
 lateinit var adapter:favouriteAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
binding= FragmentFavouriteCoinsBinding.inflate(inflater,container,false)
        return binding.root
    }


}