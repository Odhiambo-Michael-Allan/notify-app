package com.odesa.notify.ui.remindersFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.odesa.notify.MainActivity
import com.odesa.notify.R
import com.odesa.notify.databinding.FragmentRemindersBinding


class RemindersFragment : Fragment() {

    private lateinit var binding: FragmentRemindersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRemindersBinding.inflate( inflater, container, false )
        return binding.root
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle? ) {
        super.onViewCreated( view, savedInstanceState )
        ( requireActivity() as MainActivity ).apply {
            fabClicked.observe( viewLifecycleOwner ) {
                event -> event.getContentIfNotHandled()?.let { if ( it ) navigateToAddEditNotesFragment() }
        }
            tasksMenuClicked.observe( viewLifecycleOwner ) {
                event -> event.getContentIfNotHandled()?.let { if ( it ) navigateToTasksFragment() }
            }
        }
    }

    private fun navigateToAddEditNotesFragment() {
        findNavController().navigate(
            RemindersFragmentDirections.actionNavReminderToNavAddEditNote() )
    }

    private fun navigateToTasksFragment() {
        findNavController().navigate(
            RemindersFragmentDirections.actionNavReminderToNavTask()
        )
    }
    companion object {

        @JvmStatic
        fun newInstance( param1: String, param2: String ) =
            RemindersFragment()
    }
}