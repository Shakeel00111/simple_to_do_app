package com.example.todoapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.repository.Repository
import java.security.cert.Extension

class NotesViewModalFactory (

    private val repo : Repository
):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotesViewModel(repo) as T
    }
}