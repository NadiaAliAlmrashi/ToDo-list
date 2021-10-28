package com.example.todolistproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainVM(context: Application) : AndroidViewModel(context) {
    private val repo = AppRepo(context)
    fun getAllTaskToday(DateNowToday:String): MutableLiveData<List<Task>> {
        val tasks = MutableLiveData<List<Task>>()
        viewModelScope.launch {
            tasks.postValue(repo.getAllTaskToday(DateNowToday))
        }
        return tasks
    }
    fun getAllTaskComblet(): MutableLiveData<List<Task>> {
        val tasks = MutableLiveData<List<Task>>()
        viewModelScope.launch {
            tasks.postValue(repo.getAllTaskComblet( ))
        }
        return tasks
    }

    fun getAllTask(): MutableLiveData<List<Task>> {
        val tasks = MutableLiveData<List<Task>>()
        viewModelScope.launch {
            tasks.postValue(repo.getAllTask())
        }
        return tasks
    }


    fun fillDB(task: Task) = viewModelScope.launch {
        repo.fillDB(task)

    }
    fun updateData(task: Task) = viewModelScope.launch {
        repo.UpdateTask(task)

    }
    fun deletData(task: Task) = viewModelScope.launch {
        repo.DeleteTask(task)

    }
}