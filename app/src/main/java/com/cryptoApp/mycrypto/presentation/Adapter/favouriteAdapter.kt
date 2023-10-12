package com.cryptoApp.mycrypto.presentation.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.emmanuel_rono.mycrypto.databinding.CoinllistDisplayBinding

class favouriteAdapter : RecyclerView.Adapter<favouriteAdapter.favViewHolder>()
{
    inner class favViewHolder(private val binding: CoinllistDisplayBinding): ViewHolder(binding.root)
    {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): favViewHolder {
     val inflator=LayoutInflater.from(parent.context)
        val binding=CoinllistDisplayBinding.inflate(inflator,parent,false)
        return favViewHolder(binding)
    }
    override fun onBindViewHolder(holder: favViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}