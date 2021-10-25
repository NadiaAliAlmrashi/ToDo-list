package com.example.todolistproject

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class AddTaskActivity : AppCompatActivity() {
    private lateinit var date: String
    private lateinit var nameTask: EditText
    private lateinit var Description: EditText
    private lateinit var pickdate:TextView
    private lateinit var send: Button
    private lateinit var clear: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
nameTask=findViewById(R.id.txtName)
        Description=findViewById(R.id.pickDetel)
        pickdate=findViewById(R.id.pickDate)
        clear = findViewById(R.id.clear)
        send = findViewById(R.id.send)


        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        pickdate.setOnClickListener {

            DatePickerDialog(this, { _, y, m, d ->
                date = "$d/$m/$y"
                pickdate.setText(date)

            }, year, month, day)
                .show()
        }


        send.setOnClickListener{




            var task = Task(
                taskTitle = nameTask.text.toString(),
                taskDescription =Description.text.toString(),
                DateDue =pickdate.text.toString())

//var repo=AppRepo()
        }




        clear.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Reset")
            alert.setIcon(R.drawable.alert)
            alert.setMessage("Are you sure you want to clear all entries?")
            alert.setPositiveButton(R.string.yes) { _, _ ->
               nameTask.setText(null)
                Description.setText(null)
                pickdate.setText(null)

            }
            alert.setNegativeButton(R.string.no) { dialog, _ ->
                dialog.cancel()
            }
            alert.setNeutralButton(R.string.cancel) { dialog, _ ->
                dialog.cancel()
            }
            alert.show()
        }

    }


}


