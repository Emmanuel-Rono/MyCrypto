package com.cryptoApp.mycrypto.presentation.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cryptoApp.mycrypto.Utils.UIHelper.UIHelper.showChangePercent
import com.cryptoApp.mycrypto.data.CryptoEntity
import com.emmanuel_rono.mycrypto.R
import com.emmanuel_rono.mycrypto.databinding.CoinllistDisplayBinding

class CoinsAdapter(
    var coins: List<CryptoEntity>,
    private val viewListener:OnViewClickListener,
    private val favouritemListener: OnFavouritemClickListener
) : RecyclerView.Adapter<CoinsAdapter.CoinsViewHolder>() {

    interface OnFavouritemClickListener {
        fun onFavouriteClick(coin: CryptoEntity)
    }
    interface OnViewClickListener {
        fun onViewClicked(coin: CryptoEntity)
    }
    inner class CoinsViewHolder(private val binding: CoinllistDisplayBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(coin: CryptoEntity) {
            binding.apply {
                coinsItemNameTextView.text = coin.name
                coinsItemPriceTextView.text = coin.current_price.toString()
                coinsItemSymbolTextView.text = coin.symbol
                coinsItemChangeTextView.text = coin.changePercent.toString()
                Glide.with(coinsItemImageView)
                    .load(coin.image)
                    .into(coinsItemImageView)
                showChangePercent(coinsItemChangeTextView, coin.changePercent)
                favouriteImageView.setImageResource(
                    if (coin.isFavourite) {
                        R.drawable.ic_baseline_favorite_24
                    } else {
                        R.drawable.ic_baseline_favorite_border_24
                    }
                )
                root.setOnClickListener {
                    viewListener.onViewClicked(coin)
                }
                favouriteImageView.setOnClickListener {
                    favouritemListener.onFavouriteClick(coin)
                    favouriteImageView.setImageResource(
                        if (coin.isFavourite) {
                            R.drawable.ic_baseline_favorite_border_24
                        } else {
                            R.drawable.ic_baseline_favorite_24
                        })
                }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = CoinllistDisplayBinding.inflate(inflator, parent, false)
        return CoinsViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CoinsViewHolder, position: Int) {
        holder.bind(coins[position])
    }
    override fun getItemCount(): Int {
        return coins.size
    }
}
