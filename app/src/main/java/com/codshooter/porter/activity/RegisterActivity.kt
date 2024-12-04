package com.codshooter.porter.activity

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codshooter.porter.R
import com.codshooter.porter.databinding.ActivityRegisterBinding
import com.codshooter.porter.utils.LoginManager

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val loginManager by lazy {
        LoginManager(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)



        binding.languageDropDown.setDropDownBackgroundResource(R.color.white)
        binding.languageDropDown.setAdapter<ArrayAdapter<*>>(
            setUpSpinner(
                mutableListOf(
                    "Delivery",
                    "Shopping",
                    "Moving",
                )
            )
        )
        binding.languageDropDown.setOnItemClickListener { parent, _, position, _ ->
            Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT)
                .show()
        }




        binding.registerBtn.setOnClickListener {
            val name = binding.firstNameEt.text.toString()
                .trim() + " " + binding.lastNameEt.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            if (validateName(name) && validateEmail(email)) {
                Toast.makeText(this, "Register Successfully!", Toast.LENGTH_SHORT).show()
                loginManager.setLogin(true)
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }

    }

    private fun validateName(name: String): Boolean {
        return if (name.isEmpty()) {
            Toast.makeText(this, "Name cannot be empty", Toast.LENGTH_SHORT).show()
            false
        } else if (name.length < 3) {
            Toast.makeText(this, "Name should be at least 3 characters", Toast.LENGTH_SHORT)
                .show()
            false
        } else {
            true
        }
    }

    private fun validateEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$"
        return if (email.isEmpty()) {
            Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show()
            false
        } else if (!email.matches(emailRegex.toRegex())) {
            Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
            false
        } else {
            true
        }
    }

    private fun setUpSpinner(data: MutableList<String>): ArrayAdapter<String> {
        val myAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            R.layout.custom_dropdown,
            data
        )
        myAdapter.setDropDownViewResource(R.layout.custom_dropdown)
        return myAdapter
    }


}