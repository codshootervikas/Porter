package com.codshooter.porter.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
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

    }
}

