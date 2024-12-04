package com.codshooter.porter.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.codshooter.porter.R
import com.codshooter.porter.activity.LoginActivity
import com.codshooter.porter.utils.LoginManager

class AccountFragment : Fragment() {

    private val loginManager by lazy {
        LoginManager(requireActivity())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_account, container, false)

        view.findViewById<TextView>(R.id.logout).setOnClickListener {
            loginManager.setLogin(false)
            startActivity(Intent(requireActivity(), LoginActivity::class.java))
            requireActivity().finishAffinity()
        }

        return view
    }

}