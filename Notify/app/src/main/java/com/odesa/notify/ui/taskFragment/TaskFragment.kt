package com.odesa.notify.ui.taskFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import com.odesa.notify.R
import com.odesa.notify.databinding.FragmentTaskBinding


class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setHasOptionsMenu( true )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTaskBinding.inflate( inflater, container, false )
        return binding.root
    }

    override fun onCreateOptionsMenu( menu: Menu, inflater: MenuInflater ) {
        menu.clear()
        inflater.inflate( R.menu.tasks_top_app_bar_menu, menu )
    }

    companion object {
        @JvmStatic
        fun newInstance( param1: String, param2: String ) =
            TaskFragment()
    }
}