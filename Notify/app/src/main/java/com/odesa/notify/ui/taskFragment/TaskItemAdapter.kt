package com.odesa.notify.ui.taskFragment

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.odesa.notify.databinding.FragmentTaskAddTaskItemViewBinding
import com.odesa.notify.viewExtensions.showSoftKeyboard
import com.odesa.notify.databinding.FragmentTaskListItemBinding
import com.odesa.notify.model.TaskItem


class TaskItemAdapter (
    private val itemList: MutableList<TaskItem> = mutableListOf( TaskItem( taskId = "" ) )
) : ListAdapter<TaskItem, RecyclerView.ViewHolder>( TaskDiffCallback ) {

    init {
        submitList( itemList )
    }

    override fun getItemCount(): Int {
        return itemList.size + 1
    }

    override fun getItemViewType( position: Int ): Int {
        if ( position == itemCount - 1 )
            return ADD_TASK_ITEM_VIEW_TYPE
        return TASK_ITEM_VIEW_TYPE
    }
    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): RecyclerView.ViewHolder {
        return when ( viewType ) {
            TASK_ITEM_VIEW_TYPE -> TaskItemViewHolder.from( parent )
            else -> AddTaskItemViewHolder.from( parent )
        }
    }

    override fun onBindViewHolder( holder: RecyclerView.ViewHolder, position: Int ) {
        if ( position < itemCount - 1 ) {
            val task = getItem( position )
            ( holder as? TaskItemViewHolder )?.bind( task )
        }
    }

    class TaskItemViewHolder constructor ( val binding: FragmentTaskListItemBinding )
        : RecyclerView.ViewHolder( binding.root ) {

        fun bind( taskItem: TaskItem ) {
            binding.taskItemDescriptionEdittext.apply {
                setText( taskItem.description )
                if ( taskItem.description.isEmpty() )
                    requestFocus()
            }
        }

        companion object {
            fun from( parent: ViewGroup ): TaskItemViewHolder {
                val layoutInflater = LayoutInflater.from( parent.context )
                val binding = FragmentTaskListItemBinding.inflate(
                    layoutInflater, parent, false )
                return TaskItemViewHolder( binding )
            }
        }
    }

    class AddTaskItemViewHolder constructor ( val binding: FragmentTaskAddTaskItemViewBinding )
        : RecyclerView.ViewHolder ( binding.root ) {

        companion object {
            fun from( parent: ViewGroup ): AddTaskItemViewHolder {
                val layoutInflater = LayoutInflater.from( parent.context )
                val binding = FragmentTaskAddTaskItemViewBinding.inflate(
                    layoutInflater, parent, false )
                return AddTaskItemViewHolder( binding )
            }
        }
        }

    object TaskDiffCallback : DiffUtil.ItemCallback<TaskItem>() {
        override fun areItemsTheSame( oldItem: TaskItem, newItem: TaskItem ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame( oldItem: TaskItem, newItem: TaskItem ): Boolean {
            return oldItem.id == newItem.id
        }
    }

}

const val TASK_ITEM_VIEW_TYPE = Activity.RESULT_FIRST_USER + 1
const val ADD_TASK_ITEM_VIEW_TYPE = Activity.RESULT_FIRST_USER + 2