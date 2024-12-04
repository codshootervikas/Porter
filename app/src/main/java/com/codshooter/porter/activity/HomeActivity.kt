package com.codshooter.porter.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.codshooter.porter.R
import com.codshooter.porter.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val navController by lazy {
        Navigation.findNavController(this, R.id.fragmentContainerView2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        navController.navigate(R.id.home)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.home)
                    true
                }
                R.id.orders -> {
                    navController.navigate(R.id.orders)
                    true
                }
                R.id.coins -> {
                    navController.navigate(R.id.coins)
                    true
                }
                R.id.payments -> {
                    navController.navigate(R.id.payments)
                    true
                }
                R.id.account -> {
                    navController.navigate(R.id.account)
                    true
                }
                else -> false
            }
        }

    }


}

