package com.odesa.notify.ui.taskFragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.odesa.notify.R
import com.odesa.notify.databinding.FragmentTaskBinding


class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding
    private val args: TaskFragmentArgs by navArgs()

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setHasOptionsMenu( true )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTaskBinding.inflate( inflater, container, false )
        return binding.root
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle? ) {
        super.onViewCreated( view, savedInstanceState )
        setupMoreOptionsMenu()
        setupTasksAdapter()
    }

    private fun setupMoreOptionsMenu() {
        binding.moreOptionsMenu.setOnClickListener {
            val modalBottomSheet = MoreOptionsModalBottomSheet()
            modalBottomSheet.show( requireActivity().supportFragmentManager,
                MoreOptionsModalBottomSheet.TAG )
        }
        binding.addMediaContentMenu.setOnClickListener {
            val modalBottomSheet = AddMediaContentModalBottomSheet.newInstance()
            modalBottomSheet.show( requireActivity().supportFragmentManager,
                AddMediaContentModalBottomSheet.TAG )
        }
        binding.backgroundColorPaletteMenu.setOnClickListener {
            val modalBottomSheet = BackgroundColorListDialogFragment.newInstance( 10 )
            modalBottomSheet.show( requireActivity().supportFragmentManager,
                BackgroundColorListDialogFragment.TAG )
        }
    }

    private fun setupTasksAdapter() {
        binding.taskItemsRecyclerview.adapter = TaskItemAdapter()
    }

    private fun viewingExistingTask(): Boolean {
        return false
    }

    override fun onAttach( context: Context ) {
        super.onAttach( context )
    }

    @Deprecated( "Deprecated in Java" )
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater ) {
        menu.clear()
        inflater.inflate( R.menu.tasks_top_app_bar_menu, menu )
    }

    companion object {
        @JvmStatic
        fun newInstance( param1: String, param2: String ) =
            TaskFragment()
    }
}