package com.example.btvn__buoi4
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.btvn__buoi4.databinding.HomeMobileBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: HomeMobileBinding
    private lateinit var emailAddress: String
    private lateinit var pass: String
    private val userList = mutableListOf<dataUserActivity>()
    private lateinit var userAdapter: userAdapterActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeMobileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailAddress = intent.getStringExtra("username").toString()
        pass = intent.getStringExtra("pass").toString()

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        userAdapter = userAdapterActivity(userList)

        binding.recyclerView.adapter = userAdapter

        addUserToList(emailAddress, pass)

        binding.Logout.setOnClickListener {
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun addUserToList(username: String, password: String) {
        val newUser = dataUserActivity(username, password)

        userList.add(newUser)
        userAdapter.notifyDataSetChanged()
    }
}
