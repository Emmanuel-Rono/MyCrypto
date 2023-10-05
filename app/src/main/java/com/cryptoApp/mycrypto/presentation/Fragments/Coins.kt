import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.cryptoApp.mycrypto.data.Remote.api.ApiClient
import com.cryptoApp.mycrypto.data.Remote.api.ApiInterface
import com.cryptoApp.mycrypto.data.Room.CryptoDatabase
import com.cryptoApp.mycrypto.domain.CoinViewModel.CryptoViewModel
import com.cryptoApp.mycrypto.domain.coinRepository.CryptoListRepository
import com.cryptoApp.mycrypto.domain.coinRepository.CryptoLocalDataSource
import com.cryptoApp.mycrypto.domain.coinRepository.CryptoRemoteDataSource
import com.cryptoApp.mycrypto.presentation.Adapter.CoinsAdapter
import com.emmanuel_rono.mycrypto.databinding.FragmentCoinsBinding

class Coins : Fragment() {
    private lateinit var binding: FragmentCoinsBinding
    private lateinit var adapter: CoinsAdapter
    private lateinit var viewModel: CryptoViewModel
    //private lateinit var api:ApiInterface

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoinsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CoinsAdapter(emptyList())
        binding.coinsListRecyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 1)
            adapter = this@Coins.adapter
        }

        val coinDatabase = CryptoDatabase.getInstance(requireContext())
        val coinDao = coinDatabase.cryptoDao()
        val api= ApiClient.apiService
        val remoteDataSource = CryptoRemoteDataSource(coinDao,api)
        val localDataSource = CryptoLocalDataSource(coinDao, remoteDataSource)
        val coinRepository = CryptoListRepository(localDataSource, remoteDataSource)
        val viewModelFactory = CryptoViewModel.CryptoViewModelFactory(coinRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[CryptoViewModel::class.java]

        viewModel.cryptoCoinList.observe(viewLifecycleOwner) { products ->
            adapter.coins = products
            adapter.notifyDataSetChanged()
        }

        viewModel.getTheCoinList()
    }
}
