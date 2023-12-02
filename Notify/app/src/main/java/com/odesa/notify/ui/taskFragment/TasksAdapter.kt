package com.odesa.notify.ui.taskFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.odesa.notify.R
import com.odesa.notify.model.Task


class TasksAdapter : ListAdapter<Task, TasksAdapter.TaskViewHolder>( TaskDiffCallback ) {

    init {
        submitList( listOf( Task() ) )
    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): TaskViewHolder {
        val view = LayoutInflater.from( parent.context )
            .inflate( R.layout.fragment_task_list_item, parent, false )
        return TaskViewHolder( view )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = getItem( position )
        holder.bind( task )
    }

    class TaskViewHolder( taskView: View ) : RecyclerView.ViewHolder( taskView ) {

        fun bind( task: Task ) {

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