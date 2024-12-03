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


        binding.ePhone.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
               p0?.let { value ->
                   if(value.isEmpty()){
                       binding.loginBtn.visibility = View.GONE
                   }else{
                       binding.loginBtn.visibility = View.VISIBLE
                   }
               }
            }
        })

    }


    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val regex = "^[6-9]\\d{9}$".toRegex()
        return phoneNumber.matches(regex)
    }




}