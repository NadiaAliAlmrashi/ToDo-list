package com.example.todolistproject


import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Update
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class AppRepo(context:Application) {
  private val appDB = AppDataBase.getDatabase(context)

  suspend fun getAllTask(): List<Task> = withContext(Dispatchers.IO) {
    appDB.taskDao().getAllTask()
  }
  suspend fun getAllTaskComblet(): List<Task> = withContext(Dispatchers.IO) {
    appDB.taskDao().getAllTaskComblet()
  }
  suspend fun getAllTaskToday(DateNowToday:String): List<Task> = withContext(Dispatchers.IO) {
    appDB.taskDao().getAllTaskToday(DateNowToday)

  }

  suspend fun fillDB(task: Task) = withContext(Dispatchers.IO) {


      appDB.taskDao().insert(task)

    }

  suspend fun UpdateTask(task: Task) = withContext(Dispatchers.IO) {

      appDB.taskDao().update(task)

    }
    suspend fun DeleteTask(task: Task) = withContext(Dispatchers.IO) {

        appDB.taskDao().delete(task)

      }
  suspend fun searchTask(id:Int) = withContext(Dispatchers.IO) {

    appDB.taskDao().search(id)

  }
  suspend fun SortListTask() = withContext(Dispatchers.IO) {

    appDB.taskDao().sortedFind()

  }

  }
