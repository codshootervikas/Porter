package com.codshooter.porter.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.codshooter.porter.R
import com.codshooter.porter.databinding.ActivityHomeBinding
import com.codshooter.porter.fragments.AccountFragment
import com.codshooter.porter.fragments.CoinsFragment
import com.codshooter.porter.fragments.HomeFragment
import com.codshooter.porter.fragments.OrdersFragment
import com.codshooter.porter.fragments.PaymentsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private val navController by lazy {
        Navigation.findNavController(this, R.id.fragmentContainerView2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        navController.navigate(R.id.homeFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.homeFragment -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.ordersFragment -> {
                    navController.navigate(R.id.ordersFragment)
                    true
                }
                R.id.coinsFragment -> {
                    navController.navigate(R.id.coinsFragment)
                    true
                }
                R.id.paymentsFragment -> {
                    navController.navigate(R.id.paymentsFragment)
                    true
                }
                R.id.accountFragment -> {
                    navController.navigate(R.id.accountFragment)
                    true
                }
                else -> false
            }
        }

    }


}

