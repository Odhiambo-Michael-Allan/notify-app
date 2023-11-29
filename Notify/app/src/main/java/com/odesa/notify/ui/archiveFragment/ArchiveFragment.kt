package com.odesa.notify.ui.archiveFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.odesa.notify.MainActivity
import com.odesa.notify.R
import com.odesa.notify.databinding.FragmentArchiveBinding
import com.odesa.notify.ui.remindersFragment.RemindersFragmentDirections

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
        with ( requireActivity() as MainActivity ) {
            searchMenuClicked.observe( viewLifecycleOwner ) { event ->
                event.getContentIfNotHandled()?.let { if ( it ) navigateToSearchFragment() }
            }
            findViewById<BottomAppBar>( R.id.bottom_app_bar ).visibility = View.GONE
            findViewById<FloatingActionButton>( R.id.add_note_fab ).visibility = View.GONE
        }
    }

    private fun navigateToSearchFragment() {
        findNavController().navigate( ArchiveFragmentDirections.actionNavArchiveToNavSearch() )
    }

    override fun onDestroy() {
        super.onDestroy()
        with ( requireActivity() ) {
            findViewById<BottomAppBar>( R.id.bottom_app_bar )
                .visibility = View.VISIBLE
            findViewById<FloatingActionButton>( R.id.add_note_fab )
                .visibility = View.VISIBLE
        }
    }

    companion object {

        @JvmStatic
        fun newInstance( param1: String, param2: String ) =
            ArchiveFragment()
    }
}