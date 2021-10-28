package com.example.todolistproject

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.todolistproject.ui.home.HomeFragmentDirections
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_describtion.view.*
import kotlinx.android.synthetic.main.recycle_view_item.view.*
import kotlinx.coroutines.supervisorScope
import java.lang.Exception
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DescribtionFragment : Fragment() {
    private lateinit var viewModel: MainVM
    private lateinit var btnEdit: FloatingActionButton
    private lateinit var btnDelet: FloatingActionButton
    private lateinit var btnDueDate: FloatingActionButton
    private lateinit var btnDueSave: FloatingActionButton


    private lateinit var txtTetal:EditText
    private lateinit var txtDirections:EditText
    private lateinit var txtDeuDate:TextView

    private val args by navArgs<DescribtionFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_describtion, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainVM::class.java)
btnEdit=view.findViewById(R.id.floatingActionEdit)
        txtTetal=view.findViewById(R.id.TaskTitelD)
        txtDirections=view.findViewById(R.id.TaskDescribtionD)
        txtDeuDate=view.findViewById(R.id.TaskDueDateD)
        txtTetal.setText(args.describtionData.taskTitle)
        txtDirections.setText(args.describtionData.taskDescription)
        txtDeuDate.setText(args.describtionData.DateDue)
        view.TaskDateCretedD.setText(args.describtionData.datePicker)


        btnEdit.setOnClickListener {
view.TaskTitelD.isEnabled=true
view.TaskDescribtionD.isEnabled=true
view.floatingActionDuedate.isEnabled=true
view.floatingActionSave.isEnabled=true



        }
        val current = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formatted = current.format(formatter)
        btnDueDate=view.findViewById(R.id.floatingActionDuedate)
        btnDueDate.setOnClickListener{

            val c = Calendar.getInstance()
            val day = c.get(Calendar.DAY_OF_MONTH)
            val month = c.get(Calendar.MONTH)
            val year = c.get(Calendar.YEAR)
            val datePickerDialog =
                DatePickerDialog(view.context, DatePickerDialog.OnDateSetListener { view, y, m, d ->
                    val Deu = "${y}-${m + 1}-$d"

                    txtDeuDate.setText(Deu)

                }, year, month, day)
            datePickerDialog.datePicker.minDate = c.timeInMillis
            datePickerDialog.show()
        }

        btnDueSave=view.findViewById(R.id.floatingActionSave)
        btnDueSave.setOnClickListener{

            val task= Task(taskTitle= txtTetal.text.toString(),taskDescription = txtDirections.text.toString(),
                datePicker=formatted.toString(),DateDue =txtDeuDate.text.toString(),id=args.describtionData.id)

            viewModel.updateData(task)
            findNavController().navigate(R.id.action_describtionFragment_to_navigation_home)
        }
        btnDueDate=view.findViewById(R.id.floatingActionDelete)
        btnDueDate.setOnClickListener{
            val task= Task(taskTitle= txtTetal.text.toString(),taskDescription = txtDirections.text.toString(),
                datePicker=formatted.toString(),DateDue =txtDeuDate.text.toString(),id=args.describtionData.id)
             viewModel.deletData(task)
            findNavController().navigate(R.id.action_describtionFragment_to_navigation_home)
        }
    }
}


