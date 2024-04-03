package com.example.btvn__buoi4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.btvn__buoi4.databinding.SignUpScreenBinding

class signupActivity : AppCompatActivity() {
    private lateinit var binding: SignUpScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent1 = Intent(this, HomeActivity::class.java)

        binding.EmailAddress.setOnClickListener{
            intent = Intent(this, loginActivity ::class.java)
            startActivity(intent)
        }
    }

}