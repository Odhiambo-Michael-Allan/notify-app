package com.odesa.notify.ui.archiveFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.odesa.notify.R
import com.odesa.notify.databinding.FragmentArchiveBinding

class ArchiveFragment : Fragment() {

    private lateinit var binding: FragmentArchiveBinding

    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArchiveBinding.inflate( inflater, container, false )
        return binding.root
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle? ) {
        super.onViewCreated( view, savedInstanceState )
        requireActivity().findViewById<BottomAppBar>( R.id.bottom_app_bar ).visibility = View.GONE
        requireActivity().findViewById<FloatingActionButton>( R.id.add_note_fab )
            .visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().findViewById<BottomAppBar>( R.id.bottom_app_bar )
            .visibility = View.VISIBLE
        requireActivity().findViewById<FloatingActionButton>( R.id.add_note_fab )
            .visibility = View.VISIBLE
    }

    companion object {

        @JvmStatic
        fun newInstance( param1: String, param2: String ) =
            ArchiveFragment()
    }
}