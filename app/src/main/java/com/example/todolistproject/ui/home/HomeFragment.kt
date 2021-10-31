package com.example.todolistproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.example.todolistproject.MainVM

import com.example.todolistproject.R
import com.example.todolistproject.TaskRecycleViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeFragment : Fragment() {
    private lateinit var recyclerViewHome: RecyclerView
    private lateinit var AddIcon:FloatingActionButton



    // private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)


     return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AddIcon=view.findViewById(R.id.addIcon)
        recyclerViewHome=view.findViewById(R.id.rvRecycleView)
        AddIcon.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_addFragment)
        }

        val mainVM = ViewModelProvider(this).get(MainVM::class.java)


        mainVM.getAllTask().observe(viewLifecycleOwner, Observer {
             recyclerViewHome.adapter=TaskRecycleViewAdapter(it,mainVM, 1)
        })

       recyclerViewHome.layoutManager = LinearLayoutManager(context)

        }
    }
