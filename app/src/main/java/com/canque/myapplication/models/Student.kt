package com.canque.myapplication.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students_table")
data class Student (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val fName: String,
    val lName: String,
    val photoId: Int,
    val phoneNum: String,
)