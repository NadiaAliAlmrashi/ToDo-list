package com.example.todolistproject

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TaskDao
{
    @Insert
    fun insert(task: Task)

    @Query("select * From Task_list ")
    fun getAllTask() : List<Task>
    @Query("select * From Task_list where DateDue==:DateNowToday ")
    fun getAllTaskToday(DateNowToday:String) : List<Task>
    @Query("select *  From Task_list where State=1")
    fun getAllTaskComblet() : List<Task>
    @Update()
    fun update(task: Task)

    @Delete
    fun delete(task: Task)

    @Query("select * from Task_list where id== :uId")
    fun search(uId: Int): Task

    @Query("SELECT * FROM Task_list ORDER BY dateNow ASC")
    fun sortedFind(): List<Task>

}