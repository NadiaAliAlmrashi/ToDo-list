package com.example.todolistproject.ui.completed

import android.app.Application
import androidx.lifecycle.*
import com.example.todolistproject.AppRepo
import com.example.todolistproject.Task
import kotlinx.coroutines.launch



    class CompletedViewModel(context: Application) : AndroidViewModel(context) {
        private val repo = AppRepo(context)

    }