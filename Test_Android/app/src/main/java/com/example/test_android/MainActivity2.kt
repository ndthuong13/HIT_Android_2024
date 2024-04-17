package com.example.test_android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val buttonSaveNote = findViewById<Button>(R.id.buttonSaveNote)
        val editTitle = findViewById<EditText>(R.id.editTitle)
        val editContent = findViewById<EditText>(R.id.editContent)
        val buttonBack = findViewById<ImageButton>(R.id.buttonBack)

        buttonSaveNote.setOnClickListener {
            val title = editTitle.text.toString().trim()
            val content = editContent.text.toString().trim()

            if (title.isEmpty() || content.isEmpty()) {

                return@setOnClickListener
            }

            val note = Note(title, content, Date(), false)

            finish()
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }
}
