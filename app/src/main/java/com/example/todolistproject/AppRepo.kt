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
    appDB.taskDao().getAllTask()
  }
  suspend fun getAllTaskToday(): List<Task> = withContext(Dispatchers.IO) {
    appDB.taskDao().getAllTask()
  }

  suspend fun fillDB(task: Task) = withContext(Dispatchers.IO) {
    val dataDB = appDB.taskDao().getAllTask()
    if (dataDB.isEmpty()) {


      appDB.taskDao().insert(task)

    }
  }
  suspend fun UpdateTask(task: Task) = withContext(Dispatchers.IO) {


      appDB.taskDao().update(task)

    }
    suspend fun DeleteTask(task: Task) = withContext(Dispatchers.IO) {
      val dataDB = appDB.taskDao().getAllTask()
      if (dataDB.isEmpty()) {


        appDB.taskDao().update(task)

      }

  }
}