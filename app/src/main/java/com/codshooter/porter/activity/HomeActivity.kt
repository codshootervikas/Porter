package com.codshooter.porter.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        loadFragment(HomeFragment())

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> loadFragment(HomeFragment())
                R.id.orders -> loadFragment(OrdersFragment())
                R.id.coins -> loadFragment(CoinsFragment())
                R.id.payments -> loadFragment(PaymentsFragment())
                R.id.account -> loadFragment(AccountFragment())
                else -> false
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main, fragment)
            .commit()
        return true

    }
}

