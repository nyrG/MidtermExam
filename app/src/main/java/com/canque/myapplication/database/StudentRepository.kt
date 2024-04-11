package com.canque.myapplication.database

import androidx.lifecycle.LiveData
import com.canque.myapplication.models.Student

class StudentRepository(private val studentDao: StudentDao) {
    val readAllData: LiveData<List<Student>> = studentDao.readAllData()
    suspend fun addStudent(student: Student) {
        studentDao.addStudent(student)
    }

    // Other repository methods for updating, deleting, or querying data
}