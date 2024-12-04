package com.codshooter.porter.activity

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.codshooter.porter.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            val phoneNumber = binding.ePhone.text.toString().trim()
            if (isValidPhoneNumber(phoneNumber)) {
                startActivity(Intent(this, RegisterActivity::class.java))
            } else {
                Snackbar.make(binding.root, "Invalid Phone Number", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.ePhone.setOnFocusChangeListener { _, b ->
            if (b) {
                binding.loginBtn.visibility = View.VISIBLE
            } else {
                binding.loginBtn.visibility = View.GONE
            }
        }




    }

    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val regex = "^[6-9]\\d{9}$".toRegex()
        return phoneNumber.matches(regex)
    }




}