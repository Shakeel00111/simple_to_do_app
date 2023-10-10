package com.example.todoapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.R
import com.example.todoapp.data.NotesData
import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.db.NotesDatabase
import com.example.todoapp.repository.Repository
import com.example.todoapp.ui.fragments.NotesList
import com.example.todoapp.viewmodel.NotesViewModalFactory
import com.example.todoapp.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.concurrent.thread


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModalFactory:NotesViewModalFactory
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(NotesList())

        val viewModel = ViewModelProvider(this,viewModalFactory).get(NotesViewModel::class.java)

        viewModel.insertNotes(NotesData(1,"Title","Hi this is shakeel"))
        viewModel.getNotes().observe(this){
            Log.e("testing",it.toString())

        }


    }
    fun replaceFragment(fragment:Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }
}