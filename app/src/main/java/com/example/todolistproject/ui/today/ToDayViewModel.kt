package com.example.todolistproject.ui.today

import android.app.Application
import androidx.lifecycle.*
import com.example.todolistproject.AppRepo
import com.example.todolistproject.Task
import kotlinx.coroutines.launch

class ToDayViewModel(context: Application) : AndroidViewModel(context) {
    private val repo = AppRepo(context)

}