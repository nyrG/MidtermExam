package com.canque.myapplication.database

import com.canque.myapplication.dao_interfaces.StudentDao
import com.canque.myapplication.models.Student

class StudentRepository(private val studentDao: StudentDao) {
    fun insertStudent(student: Student) {
        val lastId = studentDao.getLastStudentId() ?: 0
        val nextId = lastId + 1
        val newStudent = student.copy(id = nextId)
        studentDao.insert(newStudent)
    }

    fun getAllStudents(): List<Student> {
        return studentDao.getAll()
    }

    // Other repository methods for updating, deleting, or querying data
}