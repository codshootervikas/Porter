package com.codshooter.porter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codshooter.porter.activity.Register
import com.codshooter.porter.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            val phoneNumber = binding.ePhone.text.toString().trim()
            if (isValidPhoneNumber(phoneNumber)) {
                startActivity(Intent(this, Register::class.java))
            } else {
                Toast.makeText(this, "Invalid Phone Number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val regex = "^[6-9]\\d{9}$".toRegex()
        return phoneNumber.matches(regex)
    }

}