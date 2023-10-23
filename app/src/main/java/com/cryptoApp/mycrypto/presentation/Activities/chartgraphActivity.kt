package com.cryptoApp.mycrypto.presentation.Activities

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.cryptoApp.mycrypto.data.Remote.api.ApiClientChart
import com.cryptoApp.mycrypto.data.Room.CryptoDatabase
import com.cryptoApp.mycrypto.domain.CoinViewModel.CryptoViewModel
import com.cryptoApp.mycrypto.domain.coinRepository.CryptoListRepository
import com.cryptoApp.mycrypto.domain.coinRepository.CryptoLocalDataSource
import com.cryptoApp.mycrypto.domain.coinRepository.CryptoRemoteDataSource
import com.emmanuel_rono.mycrypto.R
import com.emmanuel_rono.mycrypto.databinding.ActivityChartgraphBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class ChartGraphActivity : AppCompatActivity() {
        lateinit var binding: ActivityChartgraphBinding
        lateinit var viewModel: CryptoViewModel
        var coinId: String? = null
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityChartgraphBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val coinDatabase = CryptoDatabase.getInstance(this)
            val coinDao = coinDatabase.cryptoDao()
            val api= ApiClientChart.apiService
            val remoteDataSource = CryptoRemoteDataSource(coinDao,api)
            val localDataSource = CryptoLocalDataSource(coinDao, remoteDataSource)
            val coinRepository = CryptoListRepository(localDataSource,remoteDataSource,coinDao)
            val viewModelFactory = CryptoViewModel.CryptoViewModelFactory(coinRepository)
            viewModel = ViewModelProvider(this, viewModelFactory)[CryptoViewModel::class.java]
            coinId = intent.getStringExtra("COIN_ID")
            if (coinId == null) {
                // Handle error - no coin ID was passed
                finish()
               return
            }


            setupObservers()
            viewModel.fetchMarketChart(coinId!!)
            //viewModel.fetchMarketChart()

        }
        private fun setupObservers() {
         try {
             viewModel.coinPriceChart.observe(this) { priceData ->

                 setupChart(priceData)
             }
         }
         catch (e:Exception)
         {
             print(e.printStackTrace())

         }

            supportActionBar?.hide()
        }

    private fun setupChart(priceData: List<List<Any>>) {
        val entries = mutableListOf<Entry>()

        priceData.forEach {
            val timestamp = (it[0] as Double).toFloat()
            val price = (it[1] as Double).toFloat()
            entries.add(Entry(timestamp, price))
        }

        val dataSet = LineDataSet(entries, "Price Over Time").apply {
            color = ContextCompat.getColor(this@ChartGraphActivity, R.color.blue)
            valueTextColor = ContextCompat.getColor(this@ChartGraphActivity, R.color.black)
            setDrawFilled(true)
        }
        val lineData = LineData(dataSet)
        with(binding.chart) {
            data = lineData
            description.text = "Time"
            setDrawGridBackground(false)
            axisRight.isEnabled = false
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            invalidate()
        }
    }

    private fun hideStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // Use WindowInsetsController for API 30 and above
            val controller = window.decorView.windowInsetsController
            controller?.hide(WindowInsets.Type.statusBars())
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }
}
