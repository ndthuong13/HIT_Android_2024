package com.example.btvn__buoi4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.btvn__buoi4.databinding.HomeMobileBinding
import com.example.btvn__buoi4.databinding.LoginScreenBinding

class loginActivity: AppCompatActivity() {
    private lateinit var binding: LoginScreenBinding
    private val list = mutableListOf<dataUserActivity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.login.setOnClickListener{
            val username = binding.EmailAddress.text.toString()
            val pass = binding.Password.text.toString()
            navigateToHome(username, pass)
        }

        binding.signUp.setOnClickListener{
            val intent = Intent(this, signupActivity::class.java)
            startActivity(intent)
        }
    }
    private fun navigateToHome(emailAddress: String, password: String) {
        val intent = Intent(this, HomeMobileBinding::class.java)
        intent.putExtra("Email", emailAddress)
        intent.putExtra("pass", password)
        startActivity(intent)
    }
}