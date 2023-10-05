package com.CryptoApp.mycrypto.presentation.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emmanuel_rono.mycrypto.R
import com.emmanuel_rono.mycrypto.databinding.FragmentFavouriteCoinsBinding


class FavouriteCoins : Fragment() {
 lateinit var  binding :FragmentFavouriteCoinsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_favourite_coins, container, false)
    }

}