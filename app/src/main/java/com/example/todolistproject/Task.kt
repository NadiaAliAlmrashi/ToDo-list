package com.example.todolistproject


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime


@Entity(tableName = "Task_list")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "taskTitle") val taskTitle: String?,
    @ColumnInfo(name = "taskDescription") val taskDescription: String?,
    @ColumnInfo(name = "dateNow") val datePicker: String = LocalDate.now().toString(),
    @ColumnInfo(name = "DateDue") val DateDue: String,
    @ColumnInfo(name = "state") val State: Int


)
