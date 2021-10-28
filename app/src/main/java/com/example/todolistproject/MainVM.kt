package com.example.todolistproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVM(context: Application) : AndroidViewModel(context) {
    private val repo = AppRepo(context)


    fun getAllTask(): MutableLiveData<List<Task>> {
        val tasks = MutableLiveData<List<Task>>()
        viewModelScope.launch {
            tasks.postValue(repo.getAllTask())
        }
        return tasks
    }
//    fun getAllTaskToday(): MutableLiveData<List<Task>> {
//        val tasks = MutableLiveData<List<Task>>()
//        viewModelScope.launch {
//            tasks.postValue(repo.getAllTaskToday())
//        }
//        return tasks
//    }

    fun fillDB(task: Task) = viewModelScope.launch {
        repo.fillDB(task)

    }


}