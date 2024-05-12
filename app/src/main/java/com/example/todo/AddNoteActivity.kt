package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todo.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db:NoteDasabaseHElper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDasabaseHElper(this)

        binding.saveButton.setOnClickListener {
            val title = binding.taskEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val task = Note(0, title, content)
            db.insertNote(task)
            finish()
            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show()
        }

    }
}