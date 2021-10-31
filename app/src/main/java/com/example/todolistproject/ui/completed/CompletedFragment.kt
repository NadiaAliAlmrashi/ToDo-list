package com.example.todolistproject.ui.completed



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


class CompletedFragment : Fragment(){
    private lateinit var recyclerViewComplet: RecyclerView
 var statecomplet=1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_completed, container, false)


        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewComplet=view.findViewById(R.id.rvRecycleViewComblete)

        val mainVM = ViewModelProvider(this).get(MainVM::class.java)

        mainVM.getAllTaskComblet().observe(viewLifecycleOwner, Observer {
            recyclerViewComplet.adapter= TaskRecycleViewAdapter(it, mainVM, 3)
        })

        recyclerViewComplet.layoutManager = LinearLayoutManager(context)

    }
}



