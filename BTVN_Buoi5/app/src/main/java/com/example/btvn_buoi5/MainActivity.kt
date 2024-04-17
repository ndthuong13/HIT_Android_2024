package com.example.btvn_buoi5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.btvn_buoi5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

//    private val fragment_infor = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        binding.ButtonFragment5.setOnClickListener {
//            supportFragmentManager.commit {
//                replace(binding.FragmentContainer.id, fragment_infor)
//                setReorderingAllowed(true)
//            }
//        }
//
//        binding.ButtonFragment1.setOnClickListener {
//            supportFragmentManager.commit {
//                replace(binding.FragmentContainer.id, )
//                setReorderingAllowed(true)
//            }
//        }
    }
}