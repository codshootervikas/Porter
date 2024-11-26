package com.codshooter.porter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codshooter.porter.databinding.ActivityHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = ActivityHomeBinding.inflate(inflater, container, false)

        return binding.root
    }
}