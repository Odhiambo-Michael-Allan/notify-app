package com.odesa.notify.ui.taskFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.odesa.notify.databinding.FragmentTaskListItemBinding
import com.odesa.notify.model.TaskItem


class TaskItemAdapter : ListAdapter<TaskItem, TaskItemAdapter.TaskItemViewHolder>( TaskDiffCallback ) {


    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): TaskItemViewHolder {
        return TaskItemViewHolder.from( parent )
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int ) {
        val task = getItem( position )
        holder.bind( task )
    }

    class TaskItemViewHolder constructor( val binding: FragmentTaskListItemBinding )
        : RecyclerView.ViewHolder( binding.root ) {

        fun bind( task: TaskItem ) {

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

    object TaskDiffCallback : DiffUtil.ItemCallback<TaskItem>() {
        override fun areItemsTheSame( oldItem: TaskItem, newItem: TaskItem ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame( oldItem: TaskItem, newItem: TaskItem ): Boolean {
            return oldItem.id == newItem.id
        }
    }

}