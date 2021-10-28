package com.example.todolistproject

import android.app.Application
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistproject.ui.home.HomeFragment

class TaskRecycleViewAdapter(private val taskList: List<Task>) :
    RecyclerView.Adapter<TaskAdapter>() {
    private lateinit var check: CheckBox
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_view_item, parent, false)
        return TaskAdapter(view)
    }

    override fun onBindViewHolder(holder: TaskAdapter, position: Int) {

        val task = taskList[position]
        holder.TaskTi.text = task.taskTitle
        holder.TaskDeu.text = task.DateDue
        holder.check.setOnClickListener {


            if (holder.check.isChecked) {
                task.State = true


            }
        }


    // holder.check.isChecked

        holder.itemView.setOnClickListener { view ->

            view.findNavController().navigate(R.id.action_navigation_home_to_describtionFragment)
        }

    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}

class TaskAdapter(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    val TaskTi: TextView = itemView.findViewById(R.id.rcTaskTitel)
    val TaskDeu: TextView = itemView.findViewById(R.id.rcTaskDeu)
    val check: CheckBox = itemView.findViewById(R.id.checkBox)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Toast.makeText(itemView.context, "Done", Toast.LENGTH_SHORT).show()
    }

}



