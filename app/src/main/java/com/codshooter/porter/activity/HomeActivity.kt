package com.codshooter.porter.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.codshooter.porter.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    private val navController by lazy { findNavController(this, R.id.fragmentContainerView2) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }

                R.id.orders -> {
                    navController.navigate(R.id.orderFragment)
                    true
                }

                R.id.coins -> {
                    navController.navigate(R.id.coinFragment)
                    true
                }

                R.id.payments -> {
                    navController.navigate(R.id.paymentFragment)
                    true
                }

                R.id.account -> {
                    navController.navigate(R.id.accountFragment)
                    true
                }

                else -> false
            }
        }

    }


}

