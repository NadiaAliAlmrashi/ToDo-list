package com.example.todolistproject


import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate
import java.time.LocalTime

@Parcelize
@Entity(tableName = "Task_list")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "taskTitle") val taskTitle: String,
    @ColumnInfo(name = "taskDescription") val taskDescription: String?,
    @ColumnInfo(name = "dateNow") val datePicker: String ,
    @ColumnInfo(name = "DateDue") val DateDue: String,
    @ColumnInfo(name = "state") var State: Boolean=false):Parcelable
