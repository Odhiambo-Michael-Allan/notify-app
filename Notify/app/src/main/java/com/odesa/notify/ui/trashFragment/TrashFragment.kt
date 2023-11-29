package com.odesa.notify.ui.trashFragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.odesa.notify.R
import com.odesa.notify.databinding.FragmentTrashBinding

class TrashFragment : Fragment() {

    private lateinit var binding: FragmentTrashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTrashBinding.inflate( inflater, container, false )
        return binding.root
    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle? ) {
        super.onViewCreated( view, savedInstanceState )
//        with ( requireActivity() ) {
//            findViewById<BottomAppBar>( R.id.bottom_app_bar ).visibility = View.GONE
//            findViewById<FloatingActionButton>( R.id.add_note_fab )
//                .visibility = View.GONE
//            with ( findViewById<MaterialToolbar>( R.id.toolbar ) ) {
//                menu.findItem( R.id.search_menu ).isVisible = false
//                menu.findItem( R.id.edit_menu ).isVisible = false
//                menu.findItem( R.id.view_menu ).isVisible = false
//                menu.findItem( R.id.sort_menu ).isVisible = false
//                menu.findItem( R.id.empty_trash_menu ).isVisible = true
//            }
//        }
    }

    override fun onAttach( context: Context ) {
        super.onAttach( context )
    }

//    override fun onDestroy() {
//        super.onDestroy()
//        with ( requireActivity() ) {
//            findViewById<BottomAppBar>( R.id.bottom_app_bar )
//                .visibility = View.VISIBLE
//            findViewById<FloatingActionButton>( R.id.add_note_fab )
//                .visibility = View.VISIBLE
//            with ( findViewById<MaterialToolbar>( R.id.toolbar ) ) {
//                menu.findItem( R.id.search_menu ).isVisible = true
//                menu.findItem( R.id.edit_menu ).isVisible = true
//                menu.findItem( R.id.view_menu ).isVisible = true
//                menu.findItem( R.id.sort_menu ).isVisible = true
//                menu.findItem( R.id.empty_trash_menu ).isVisible = false
//            }
//        }
//    }

    companion object {
        @JvmStatic
        fun newInstance( param1: String, param2: String ) =
            TrashFragment()
    }
}