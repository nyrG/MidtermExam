package com.canque.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.canque.myapplication.adapter.StudentAdapter
import com.canque.myapplication.databinding.ActivityMainBinding
import com.canque.myapplication.models.Student

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val students: MutableList<Student> = ArrayList()

        students.add(Student(1 , "John", "Doe", 1, "09616497885"))
        students.add(Student(2 , "Saturo", "Gojo", 2, "09616497885"))
        students.add(Student(3 , "Monkey", "Luffy", 3, "09616497885"))
        students.add(Student(4 , "Naruto", "Uzumaki", 4, "09616497885"))
        students.add(Student(5 , "John", "Doe", 5, "09616497885"))
        students.add(Student(6 , "Saturo", "Gojo", 6, "09616497885"))
        students.add(Student(7 , "Monkey", "Luffy", 7, "09616497885"))
        students.add(Student(8 , "Naruto", "Uzumaki", 8, "09616497885"))
        students.add(Student(9 , "John", "Doe", 9, "09616497885"))
        students.add(Student(10 , "Saturo", "Gojo", 10, "09616497885"))
        students.add(Student(11 , "Monkey", "Luffy", 11, "09616497885"))
        students.add(Student(12 , "Naruto", "Uzumaki", 12, "09616497885"))

        binding.studentList.layoutManager = LinearLayoutManager(this)
        binding.studentList.adapter = StudentAdapter(
            this, // Adding this parameter since we need the context of the current screen.
            students
        )
    }
}