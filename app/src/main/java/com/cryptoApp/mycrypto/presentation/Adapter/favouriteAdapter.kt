package com.cryptoApp.mycrypto.presentation.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.cryptoApp.mycrypto.Utils.UIHelper
import com.cryptoApp.mycrypto.data.CryptoEntity
import com.emmanuel_rono.mycrypto.R
import com.emmanuel_rono.mycrypto.databinding.CoinllistDisplayBinding

class favouriteAdapter(
    var favCoins: List<CryptoEntity>, var viewListener: onViewClickListener,
    var favViewListner: onFavViewListener): RecyclerView.Adapter<favouriteAdapter.favViewHolder>()
{

    interface onViewClickListener
    {
        fun onViewClicked(favCoins:CryptoEntity )
    }
    interface onFavViewListener
    {
        fun  onFavViewClicked(favCoins: CryptoEntity)
    }

    inner class favViewHolder(private val binding: CoinllistDisplayBinding): ViewHolder(binding.root)
    {
       //interface of ClickListeners

        fun bind(favCoins: CryptoEntity) {
            binding.apply {
                coinsItemNameTextView.text = favCoins.name
                coinsItemPriceTextView.text = favCoins.current_price.toString()
                coinsItemSymbolTextView.text = favCoins.symbol
                coinsItemChangeTextView.text = favCoins.changePercent.toString()
                Glide.with(coinsItemImageView)
                    .load(favCoins.image)
                    .into(coinsItemImageView)
                UIHelper.UIHelper.showChangePercent(coinsItemChangeTextView, favCoins.changePercent)
                favouriteImageView.setImageResource(
                    if (favCoins.isFavourite) {
                        R.drawable.ic_baseline_favorite_24
                    } else {
                        R.drawable.ic_baseline_favorite_border_24
                    }
                )
                root.setOnClickListener {
                    viewListener.onViewClicked(favCoins)
                }
                favouriteImageView.setOnClickListener {
                    favViewListner.onFavViewClicked(favCoins)
                    favouriteImageView.setImageResource(
                        if (favCoins.isFavourite) {
                            R.drawable.ic_baseline_favorite_border_24
                        } else {
                            R.drawable.ic_baseline_favorite_24
                        })
                }
    }}}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): favViewHolder {
     val inflator=LayoutInflater.from(parent.context)
        val binding=CoinllistDisplayBinding.inflate(inflator,parent,false)
        return favViewHolder(binding)
    }
    override fun onBindViewHolder(holder: favViewHolder, position: Int) {
        holder.bind(favCoins[position])
    }
    override fun getItemCount(): Int {
      return favCoins.size
    }

}