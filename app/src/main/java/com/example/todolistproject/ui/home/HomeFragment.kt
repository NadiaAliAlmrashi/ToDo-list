package com.example.todolistproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.RecyclerView

import com.example.todolistproject.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeFragment : Fragment() {
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

        AddIcon.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_home_to_addFragment)
        }
    }
}