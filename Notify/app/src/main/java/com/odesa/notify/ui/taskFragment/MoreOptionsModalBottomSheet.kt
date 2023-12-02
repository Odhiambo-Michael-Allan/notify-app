package com.odesa.notify.ui.taskFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.odesa.notify.databinding.FragmentModalBottomSheetBinding

class MoreOptionsModalBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentModalBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentModalBottomSheetBinding.inflate( inflater, container, false )
        return binding.root
    }

    companion object {
        const val TAG = "MoreOptionsModalBottomSheet"
    }
}