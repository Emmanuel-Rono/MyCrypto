package com.CryptoApp.mycrypto.presentation.Activities


import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.emmanuel_rono.mycrypto.R
import com.emmanuel_rono.mycrypto.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        hideStatusBar() // Now, try to hide the status bar
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)
        supportActionBar?.hide()
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_favourites -> {
                    navController.navigate(R.id.action_coins_to_favouriteCoins)
                    true
                }
                else -> false
            }
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







