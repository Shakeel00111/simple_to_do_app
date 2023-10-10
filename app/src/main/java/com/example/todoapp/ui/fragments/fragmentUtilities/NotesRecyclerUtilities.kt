package com.example.todoapp.ui.fragments.fragmentUtilities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todoapp.data.NotesData
import com.example.todoapp.databinding.NotesListRvBinding

class NotesViewHolder(private val itemBinding:NotesListRvBinding):ViewHolder(itemBinding.root){

    fun bindData(notesData: NotesData,listener: OnClickListener){

        itemBinding.tvTittle.text = notesData.title

        itemBinding.image.setOnClickListener{
            listener.onClickdelete(notesData)
        }
    }
}

class NotesRecyclerUtilities(val listofNotes: List<NotesData>,private val listener:OnClickListener):
    RecyclerView.Adapter<NotesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding = NotesListRvBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
                )
        return NotesViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return listofNotes.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bindData(listofNotes[position],listener)
    }
}

interface OnClickListener{
     fun onClickdelete(notesData : NotesData)
}