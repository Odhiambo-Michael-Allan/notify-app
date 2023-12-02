package com.odesa.notify.ui.taskFragment

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.odesa.notify.databinding.FragmentBackgroundColorDialogBinding
import com.odesa.notify.databinding.FragmentBackgroundColorDialogListItemBinding
import timber.log.Timber

// TODO: Customize parameter argument names
const val ARG_ITEM_COUNT = "item_count"

/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    BackgroundColorListDialogFragment.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 */
class BackgroundColorListDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBackgroundColorDialogBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding =
            FragmentBackgroundColorDialogBinding.inflate(
                inflater, container, false )
        return binding.root

    }

    override fun onViewCreated( view: View, savedInstanceState: Bundle? ) {
        binding.backgroundColorRecyclerview.adapter =
            arguments?.getInt( ARG_ITEM_COUNT )?.let { ItemAdapter( it ) }
        Timber.d( "Background color recyclerview adapter: " +
                "${binding.backgroundColorRecyclerview.adapter}" )
    }

    private inner class ViewHolder (
        binding: FragmentBackgroundColorDialogListItemBinding
    ) :
        RecyclerView.ViewHolder( binding.root ) {}

    private inner class ItemAdapter ( private val mItemCount: Int ) :
        RecyclerView.Adapter<ViewHolder>() {

        override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): ViewHolder {

            return ViewHolder(
                FragmentBackgroundColorDialogListItemBinding.inflate(
                    LayoutInflater.from( parent.context ),
                    parent,
                    false
                )
            )

        }

        override fun onBindViewHolder( holder: ViewHolder, position: Int ) {
//            holder.text.text = position.toString()
        }

        override fun getItemCount(): Int {
            return mItemCount
        }
    }

    companion object {

        const val TAG = "BackgroundColorModalBottomSheet"

        // TODO: Customize parameters
        fun newInstance( itemCount: Int ): BackgroundColorListDialogFragment =
            BackgroundColorListDialogFragment().apply {
                arguments = Bundle().apply {
                    putInt( ARG_ITEM_COUNT, itemCount )
                }
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}