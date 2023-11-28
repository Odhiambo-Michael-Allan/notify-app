package com.odesa.notify.ui.notesFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.odesa.notify.MainActivity
import com.odesa.notify.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private lateinit var binding: FragmentNotesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNotesBinding.inflate( inflater, container, false )
        return binding.root
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle? ) {
        super.onViewCreated( view, savedInstanceState )
        ( requireActivity() as MainActivity ).apply {
            getFabStatus().observe( viewLifecycleOwner ) {
                    event -> event.getContentIfNotHandled()?.let { if ( it ) navigateToAddEditNoteFragment() }
            }
            getTasksMenuItemStatus().observe( viewLifecycleOwner ) {
                event -> event.getContentIfNotHandled()?.let { if ( it ) navigateToTasksFragment() }
            }
        }
    }

    private fun navigateToAddEditNoteFragment() {
        findNavController().navigate( NotesFragmentDirections.actionNavNotesToNavAddEditNote() )
    }

    private fun navigateToTasksFragment() {
        findNavController().navigate( NotesFragmentDirections.actionNavNotesToNavTask() )
    }

    companion object {

        @JvmStatic
        fun newInstance( param1: String, param2: String ) =
            NotesFragment()
    }
}