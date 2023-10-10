package com.example.todoapp.repository

import androidx.lifecycle.LiveData
import com.example.todoapp.data.NotesData
import com.example.todoapp.db.NotesDatabase

class Repository (

    private val db:NotesDatabase
){

    fun getData():LiveData<List<NotesData>> = db.getData().getNotes()

    fun insertNotes(notesData : NotesData) = db.getData().insertNotes(notesData)

    fun onDelete(notesData: NotesData) = db.getData().delete(notesData)

}