package com.CryptoApp.mycrypto.presentation.Activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.emmanuel_rono.mycrypto.R
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
       // val navHostFragment =
        ///    supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        //val navController = navHostFragment.navController
        //bottomNavigationView.setupWithNavController(navController)
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // Hide the status bar
          // window.decorView.systemUiVisibility = hideStatusBarFlags()
            //setContentView(R.layout.activity_main)

        }
    }

       // private fun hideStatusBarFlags(): Int {
          //  return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
           //   View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
              //          View.SYSTEM_UI_FLAG_LAYOUT_STABLE
           // } else {
             //   @Suppress("DEPRECATION")
              //  WindowManager.LayoutParams.FLAG_FULLSCREEN
          // }
      //  }
   // }