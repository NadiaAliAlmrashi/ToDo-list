package com.example.todolistproject

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistproject.ui.completed.CompletedFragmentDirections
import com.example.todolistproject.ui.home.HomeFragmentDirections
import com.example.todolistproject.ui.today.ToDayFragment
import com.example.todolistproject.ui.today.ToDayFragmentDirections
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class TaskRecycleViewAdapter(private val taskList: List<Task>, val mainVM: MainVM, val i: Int) :
    RecyclerView.Adapter<TaskAdapter>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_view_item, parent, false)
        return TaskAdapter(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: TaskAdapter, position: Int) {
        val current = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-M-d")
        val formatted = current.format(formatter)
        val task = taskList[position]
        holder.TaskTi.text = task.taskTitle
        holder.TaskDeu.text = task.DateDue

        holder.check.isChecked = false
        val Card = holder.itemView.findViewById<CardView>(R.id.cardColor)
        val colorDone = holder.itemView.resources.getColor(R.color.green)
        val colorDefolt = holder.itemView.resources.getColor(R.color.itemDefolt)
        val colorTimeOver = holder.itemView.resources.getColor(android.R.color.darker_gray)
        if (task.State == true) {
            holder.check.isChecked = true
            holder.CardColor.setCardBackgroundColor(colorDone)
        } else {
            if (task.DateDue.isNotEmpty())
                if (task.DateDue < formatted) {
                    if (task.State == false) {
                        holder.CardColor.setCardBackgroundColor(colorTimeOver)
                        holder.check.isEnabled = false
                    }
                } else {
                    holder.CardColor.setCardBackgroundColor(colorDefolt)
                }
        }

        holder.check.setOnCheckedChangeListener { _, ischeeck ->

            if (ischeeck) {


                task.State = true
                Card.setCardBackgroundColor(colorDone)
                mainVM.updateData(task)
            } else {

                task.State = false
                Card.setCardBackgroundColor(colorDefolt)
                mainVM.updateData(task)
            }

        }
        task.State = holder.check.isChecked



        task.State = holder.check.isChecked

        holder.itemView.setOnClickListener { view ->
            val action = when (i) {
                3 -> CompletedFragmentDirections.actionNavigationCompletedToDescribtionFragment(task)
                2 -> ToDayFragmentDirections.actionNavigationTodayToDescribtionFragment(task)
                else -> HomeFragmentDirections.actionNavigationHomeToDescribtionFragment(task)
            }

            view.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}

class TaskAdapter(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
    val TaskTi: TextView = itemView.findViewById(R.id.rcTaskTitel)
    val TaskDeu: TextView = itemView.findViewById(R.id.rcTaskDeu)
    var check: CheckBox = itemView.findViewById(R.id.checkBox)
    var CardColor: androidx.cardview.widget.CardView = itemView.findViewById(R.id.cardColor)

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Toast.makeText(itemView.context, "Done", Toast.LENGTH_SHORT).show()
    }

}



