package com.example.todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.R
import com.example.todoapp.data.NotesData
import com.example.todoapp.databinding.FragmentNotesAddBinding
import com.example.todoapp.databinding.FragmentNotesListBinding
import com.example.todoapp.viewmodel.NotesViewModalFactory
import com.example.todoapp.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NotesAdd : Fragment() {
    @Inject
    lateinit var viewModalFactory: NotesViewModalFactory
    private lateinit var notesAddBinding: FragmentNotesAddBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notesAddBinding= FragmentNotesAddBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return notesAddBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModal = ViewModelProvider(this ,viewModalFactory).get(NotesViewModel::class.java)
        notesAddBinding.edbutton.setOnClickListener {

            val title = notesAddBinding.etTitle.text.toString()
            val description = notesAddBinding.etdescription.text.toString()

            viewModal.insertNotes(NotesData(title = title, description = description))
            replaceFragment(NotesList())
        }
    }

    private fun replaceFragment(fragment: Fragment){
        parentFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()
    }

}