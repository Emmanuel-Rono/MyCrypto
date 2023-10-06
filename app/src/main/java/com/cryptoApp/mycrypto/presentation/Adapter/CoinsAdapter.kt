package com.cryptoApp.mycrypto.presentation.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cryptoApp.mycrypto.data.CryptoEntity
import com.emmanuel_rono.mycrypto.databinding.CoinllistDisplayBinding

class CoinsAdapter (var coins:List<CryptoEntity>): RecyclerView.Adapter<CoinsAdapter.CoinsViewHolder>()
{
    inner class CoinsViewHolder(private val binding: CoinllistDisplayBinding):RecyclerView.ViewHolder(binding.root)
    {
        var image=binding.coinsItemImageView
        var coinSymbol=binding.coinsItemSymbolTextView
        var coinPrice=binding.coinsItemPriceTextView
        var coinPriceChange=binding.coinsItemChangeTextView
        var coinName=binding.coinsItemNameTextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinsViewHolder {
        val inflator=LayoutInflater.from(parent.context)
        val binding=CoinllistDisplayBinding.inflate(inflator,parent,false)
       return CoinsViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CoinsViewHolder, position: Int) {
         val item=coins[position]
        holder.coinName.text= item.name.toString()
        holder.coinPrice.text= item.current_price.toString()
        holder.coinSymbol.text=item.symbol
        holder.coinPriceChange.text= item.changePercent.toString()
        Glide.with(holder.image)
            .load(item.image)
            .into(holder.image)
    }
    override fun getItemCount(): Int {
        return coins.size
    }
}