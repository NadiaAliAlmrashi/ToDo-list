package com.example.todolistproject


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime


@Entity (tableName ="Task_list")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "taskTitle") val taskTitle: String?,
    @ColumnInfo(name = "taskDescription") val taskDescription: String?,
    @ColumnInfo(name = "datePicker") val datePicker: LocalDate = LocalDate.now(),
    @ColumnInfo(name = "timePicker") val timePicker: LocalTime = LocalTime.now(),
    @ColumnInfo(name = "DateDue") val DateDue: String


    )
