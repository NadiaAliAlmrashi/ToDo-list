package com.example.todolistproject.ui.completed

import android.app.Application
import androidx.lifecycle.*
import com.example.todolistproject.AppRepo
import com.example.todolistproject.Task
import kotlinx.coroutines.launch



    class CompletedViewModel(context: Application) : AndroidViewModel(context) {
        private val repo = AppRepo(context)
        fun getAllTaskComblet(): MutableLiveData<List<Task>> {
            val tasks = MutableLiveData<List<Task>>()
            viewModelScope.launch {
                tasks.postValue(repo.getAllTaskComblet( ))
            }
            return tasks
        }
    }