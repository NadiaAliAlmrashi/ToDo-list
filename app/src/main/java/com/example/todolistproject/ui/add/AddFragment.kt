package com.example.todolistproject.ui.add

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.todolistproject.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class AddFragment : Fragment() {

    private lateinit var date: String
    private lateinit var nameTask: EditText
    private lateinit var Description: EditText
    private lateinit var pickdate: TextView
    private lateinit var addButten: Button
    private lateinit var clear: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
      val view= inflater.inflate(R.layout.fragment_add, container, false)


    return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTask=view.findViewById(R.id.txtName)
        Description=view.findViewById(R.id.pickDetel)
        pickdate=view.findViewById(R.id.pickDate)
        clear = view.findViewById(R.id.clear)
        addButten =view.findViewById(R.id.AddTask)

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val formatted = current.format(formatter)


        pickdate.setOnClickListener {

            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)
            val datePickerDialog =
                DatePickerDialog(view.context, DatePickerDialog.OnDateSetListener { view, y, m, d ->
                    val Deu = "$y/${m + 1}/$d"

                    pickdate.setText(Deu)

                }, year, month, day)
            datePickerDialog.datePicker.minDate = c.timeInMillis
            datePickerDialog.show()





            addButten.setOnClickListener {
            }




            clear.setOnClickListener {
                val alert = AlertDialog.Builder(context)
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


        }}}







