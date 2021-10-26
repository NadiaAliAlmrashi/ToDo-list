package com.example.todolistproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class TaskRecycleViewAdapter(private val taskList: List<Task>) :
        RecyclerView.Adapter<TaskAdapter>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycle_view_item, parent, false)
            return TaskAdapter(view)
        }

        override fun onBindViewHolder(holder: TaskAdapter, position: Int) {
            val task = taskList[position]
            holder.TaskTi.text = task.taskTitle
            holder.TaskDeu.text = task.DateDue
        }

        override fun getItemCount(): Int {
            return taskList.size
        }
    }

    class TaskAdapter(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val TaskTi: TextView = itemView.findViewById(R.id.rcTaskTitel)
        val TaskDeu: TextView = itemView.findViewById(R.id.rcTaskDeu)


        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Toast.makeText(itemView.context, "Done", Toast.LENGTH_SHORT).show()
        }
    }


