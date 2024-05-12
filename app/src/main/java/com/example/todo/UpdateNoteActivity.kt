package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todo.databinding.ActivityUpdateBinding

class UpdateNoteActivity : AppCompatActivity() {

    private  lateinit var binding:ActivityUpdateBinding
    private  lateinit var db: NoteDasabaseHElper
    private var noteId:Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDasabaseHElper(this)

        noteId = intent.getIntExtra("note_id",-1)
        if (noteId == -1) {
            finish()
            return
        }

        val note = db.getNoteByID(noteId)
        binding.updatetitileEditText.setText(note.title)
        binding.updateContentEditText.setText(note.content)

        binding.updateSaveButton.setOnClickListener{
            val  newTitle = binding.updatetitileEditText.text.toString()
            val  newContent = binding.updateContentEditText.text.toString()
            val  updateTask = Note(noteId, newTitle, newContent)
            db.updateNote(updateTask)
            finish()
            Toast.makeText(this, "Change Saved", Toast.LENGTH_SHORT).show()
        }


    }
}