package com.example.todoapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.data.NotesData
import com.example.todoapp.databinding.FragmentNotesAddBinding
import com.example.todoapp.databinding.FragmentNotesListBinding
import com.example.todoapp.db.NotesDatabase
import com.example.todoapp.repository.Repository
import com.example.todoapp.ui.fragments.fragmentUtilities.NotesRecyclerUtilities
import com.example.todoapp.ui.fragments.fragmentUtilities.OnClickListener
import com.example.todoapp.viewmodel.NotesViewModalFactory
import com.example.todoapp.viewmodel.NotesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NotesList : Fragment(),OnClickListener {
    lateinit var viewModel: NotesViewModel
    @Inject
    lateinit var viewModalFactory:NotesViewModalFactory
    private lateinit var notesListBinding: FragmentNotesListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        notesListBinding = FragmentNotesListBinding.inflate(inflater, container, false)
        return notesListBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notesListBinding.flbutton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container,NotesAdd())
                .commit()
        }


         viewModel = ViewModelProvider(this,viewModalFactory).get(NotesViewModel::class.java)

        viewModel.getNotes().observe(viewLifecycleOwner){
            val adapter = NotesRecyclerUtilities(it,this)
            notesListBinding.recycleview.adapter = adapter
            notesListBinding.recycleview.layoutManager = LinearLayoutManager(requireContext())

        }
    }

    override fun onClickdelete(notesData: NotesData) {
        viewModel.onDelete(notesData)
    }
}


