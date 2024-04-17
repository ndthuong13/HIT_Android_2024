package com.example.test_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.commit
import com.example.test_android.databinding.ActivityMainBinding
import java.util.Date


class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val allNoteFragment = AllNoteFragment()
    private val favouriteFragment = FavouriteFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonShowAllNote.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.FragmentContainer.id, allNoteFragment)
                setReorderingAllowed(true)
            }
        }

        binding.buttonFavouriteNote.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.FragmentContainer.id, favouriteFragment)
                setReorderingAllowed(true)
            }
        }

        binding.buttonAddNote.setOnClickListener {
            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}