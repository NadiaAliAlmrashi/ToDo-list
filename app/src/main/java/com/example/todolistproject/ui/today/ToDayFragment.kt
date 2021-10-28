package com.example.todolistproject.ui.today


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todolistproject.MainVM
import com.example.todolistproject.R
import com.example.todolistproject.TaskRecycleViewAdapter
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class ToDayFragment : Fragment() {
    private lateinit var recyclerViewToday: RecyclerView
    val current = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val formatted = current.format(formatter)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_today, container, false)


        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewToday=view.findViewById(R.id.rvRecycleViewToday)

        val mainVM = ViewModelProvider(this).get(MainVM::class.java)

        mainVM.getAllTaskToday(formatted).observe(viewLifecycleOwner, Observer {
            recyclerViewToday.adapter= TaskRecycleViewAdapter(it, mainVM, 2)
        })

        recyclerViewToday.layoutManager = LinearLayoutManager(context)

    }
}



