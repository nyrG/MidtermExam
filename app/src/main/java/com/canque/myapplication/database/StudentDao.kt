package com.canque.myapplication.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.canque.myapplication.models.Student

@Dao
interface StudentDao {
    @Query("SELECT * FROM students_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Student>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStudent(student: Student)

    // Define other methods for updating, deleting, or querying data
}