package com.example.todolistproject.ui.today

import android.app.Application
import androidx.lifecycle.*
import com.example.todolistproject.AppRepo
import com.example.todolistproject.Task
import kotlinx.coroutines.launch

class ToDayViewModel(context: Application) : AndroidViewModel(context) {
    private val repo = AppRepo(context)
    fun getAllTaskToday(DateNowToday:String): MutableLiveData<List<Task>> {
        val tasks = MutableLiveData<List<Task>>()
        viewModelScope.launch {
            tasks.postValue(repo.getAllTaskToday(DateNowToday))
        }
        return tasks
    }
}