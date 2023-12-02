package com.odesa.notify.ui.taskFragment

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.odesa.notify.databinding.FragmentAddMediaContentModalBottomSheetListDialogBinding

/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    AddMediaContentModalBottomSheet.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 */
class AddMediaContentModalBottomSheet : BottomSheetDialogFragment() {

    private var _binding: FragmentAddMediaContentModalBottomSheetListDialogBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddMediaContentModalBottomSheetListDialogBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    companion object {

        const val TAG = "AddMediaContentModalBottomSheet"

        // TODO: Customize parameters
        fun newInstance(): AddMediaContentModalBottomSheet =
            AddMediaContentModalBottomSheet()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}