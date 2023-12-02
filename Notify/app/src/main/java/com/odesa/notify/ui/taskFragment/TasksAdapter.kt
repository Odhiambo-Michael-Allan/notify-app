package com.odesa.notify.ui.taskFragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.odesa.notify.R
import com.odesa.notify.databinding.FragmentTaskListItemBinding
import com.odesa.notify.model.Task


class TasksAdapter : ListAdapter<Task, TasksAdapter.TaskViewHolder>( TaskDiffCallback ) {

    init {
        submitList( listOf( Task() ) )
    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): TaskViewHolder {
        return TaskViewHolder.from( parent )
    }

    override fun onBindViewHolder( holder: TaskViewHolder, position: Int ) {
        val task = getItem( position )
        holder.bind( task )
    }

    class TaskViewHolder constructor( val binding: FragmentTaskListItemBinding )
        : RecyclerView.ViewHolder( binding.root ) {

        fun bind( task: Task ) {
            if ( task.isEmpty )
                binding.taskDescriptionEdittext.requestFocus()
        }

        companion object {
            fun from( parent: ViewGroup ): TaskViewHolder {
                val layoutInflater = LayoutInflater.from( parent.context )
                val binding = FragmentTaskListItemBinding.inflate(
                    layoutInflater, parent, false )
                return TaskViewHolder( binding )
            }
        }
    }

    object TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame( oldItem: Task, newItem: Task ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame( oldItem: Task, newItem: Task ): Boolean {
            return oldItem.id == newItem.id
        }
    }

}