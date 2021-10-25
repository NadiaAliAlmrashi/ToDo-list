package com.example.todolistproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainVM(context: Application) : AndroidViewModel(context) {}
////    private val repo =AppRepo(context)
//
//
//    fun getAllUsers(): MutableLiveData<List<Task>> {
//        val users = MutableLiveData<List<Task>>()
//        viewModelScope.launch {
//            users.postValue(repo.getAllTask())
//        }
//        return users
//    }
//    fun fillDB() = viewModelScope.launch{
//        repo.f
//    }
//
//}