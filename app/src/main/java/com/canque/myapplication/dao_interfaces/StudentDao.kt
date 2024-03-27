package com.canque.myapplication.dao_interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.canque.myapplication.models.Student

@Dao
interface StudentDao {
    @Query("SELECT MAX(id) FROM students")
    fun getLastStudentId(): Int?
    @Query("SELECT * FROM students")
    fun getAll(): List<Student>
    @Insert
    fun insert(student: Student)

    // Define other methods for updating, deleting, or querying data
}