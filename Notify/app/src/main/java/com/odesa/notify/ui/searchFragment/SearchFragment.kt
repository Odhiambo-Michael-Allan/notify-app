package com.odesa.notify.ui.searchFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.odesa.notify.R
import com.odesa.notify.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate( inflater, container, false )
        return binding.root
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle? ) {
        super.onViewCreated( view, savedInstanceState )
        with( requireActivity() ) {
            findViewById<BottomAppBar>( R.id.bottom_app_bar )
                .visibility = View.GONE
            findViewById<FloatingActionButton>( R.id.add_note_fab )
                .visibility = View.GONE
            findViewById<MaterialToolbar>( R.id.toolbar ).apply {
                menu.findItem( R.id.search_menu ).isVisible = false
                menu.findItem( R.id.edit_menu ).isVisible = false
                menu.findItem( R.id.view_menu ).isVisible = false
                menu.findItem( R.id.sort_menu ).isVisible = false
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        with( requireActivity() ) {
            findViewById<BottomAppBar>( R.id.bottom_app_bar )
                .visibility = View.VISIBLE
            findViewById<FloatingActionButton>( R.id.add_note_fab )
                .visibility = View.VISIBLE
            findViewById<MaterialToolbar>( R.id.toolbar ).apply {
                menu.findItem( R.id.search_menu ).isVisible = true
                menu.findItem( R.id.edit_menu ).isVisible = true
                menu.findItem( R.id.view_menu ).isVisible = true
                menu.findItem( R.id.sort_menu ).isVisible = true
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance( param1: String, param2: String ) =
            SearchFragment()
    }
}