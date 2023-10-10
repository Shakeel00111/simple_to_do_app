package com.example.todoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.NotesData
import com.example.todoapp.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel (
    private val repo:Repository
):ViewModel(){
    fun insertNotes(notesData: NotesData) = CoroutineScope(Dispatchers.IO).launch { repo.insertNotes(notesData) }

    fun getNotes():LiveData<List<NotesData>> = repo.getData()

        fun onDelete(notesData: NotesData) = CoroutineScope(Dispatchers.IO).launch {
        repo.onDelete(notesData)
    }
}