package com.odesa.notify.ui.notesFragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.odesa.notify.MainActivity
import com.odesa.notify.R
import com.odesa.notify.databinding.FragmentNotesBinding
import timber.log.Timber

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
        with ( requireActivity() as MainActivity ) {
            fabClicked.observe( viewLifecycleOwner ) {
                    event -> event.getContentIfNotHandled()?.let { if ( it )
                        navigateToAddEditNoteFragment() }
            }
            tasksMenuClicked.observe( viewLifecycleOwner ) {
                event -> event.getContentIfNotHandled()?.let { if ( it ) navigateToTasksFragment() }
            }
            searchMenuClicked.observe( viewLifecycleOwner ) {
                event -> event.getContentIfNotHandled()?.let { if ( it ) navigateToSearchFragment() }
            }
        }
    }

    private fun navigateToAddEditNoteFragment() {
        findNavController().navigate( NotesFragmentDirections.actionNavNotesToNavAddEditNote() )
    }

    private fun navigateToTasksFragment() {
        findNavController().navigate( NotesFragmentDirections.actionNavNotesToNavTask() )
    }

    private fun navigateToSearchFragment() {
        findNavController().navigate( NotesFragmentDirections.actionNavNotesToNavSearch() )
    }


    companion object {

        @JvmStatic
        fun newInstance( param1: String, param2: String ) =
            NotesFragment()
    }
}