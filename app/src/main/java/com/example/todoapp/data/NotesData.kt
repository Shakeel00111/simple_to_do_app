package com.example.todoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("notes_table")
data class NotesData(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val title:String,
    val description:String

)
