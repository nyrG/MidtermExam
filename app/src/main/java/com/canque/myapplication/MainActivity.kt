package com.canque.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.canque.myapplication.adapter.StudentAdapter
import com.canque.myapplication.databinding.ActivityMainBinding
import com.canque.myapplication.models.Student
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.constraintlayout.widget.ConstraintLayout
import com.canque.myapplication.database.AppDatabase
import com.canque.myapplication.database.StudentRepository


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = AppDatabase.getInstance(this)
        val studentDao = db.studentDao()

        val studentRepository = StudentRepository(studentDao)

        val student = Student(
            fName ="Stacy",
            lName = "Wallace",
            photoId = R.mipmap.student_1,
            phoneNum = "1234567890")

        studentRepository.insertStudent(student)

        val students = studentRepository.getAllStudents()

        /*students.add(Student(1 , "John", "Doe", 1, "09616497885"))
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
        students.add(Student(12 , "Naruto", "Uzumaki", 12, "09616497885"))*/

        binding.studentList.layoutManager = LinearLayoutManager(this)
        binding.studentList.adapter = StudentAdapter(
            this, // Adding this parameter since we need the context of the current screen.
            students.toMutableList()
        )

        ViewCompat.setOnApplyWindowInsetsListener(binding.addStudent) { v, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Apply the insets as a margin to the view. This solution sets
            // only the bottom, left, and right dimensions, but you can apply whichever
            // insets are appropriate to your layout. You can also update the view padding
            // if that's more appropriate.
            val params = v.layoutParams as ConstraintLayout.LayoutParams
            params.leftMargin = insets.left
            params.bottomMargin = insets.bottom + 40
            params.rightMargin = insets.right + 40
            v.layoutParams = params

            // Invalidate the layout to ensure the changes take effect
            v.requestLayout()

            // Return CONSUMED if you don't want want the window insets to keep passing
            // down to descendant views.
            WindowInsetsCompat.CONSUMED
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.studentList) { v, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Apply the insets as a margin to the view. This solution sets
            // only the bottom, left, and right dimensions, but you can apply whichever
            // insets are appropriate to your layout. You can also update the view padding
            // if that's more appropriate.
            val params = v.layoutParams as ConstraintLayout.LayoutParams
            params.bottomMargin = insets.bottom
            v.layoutParams = params

            // Invalidate the layout to ensure the changes take effect
            v.requestLayout()

            // Return CONSUMED if you don't want want the window insets to keep passing
            // down to descendant views.
            WindowInsetsCompat.CONSUMED
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.constraintLayout) { v, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Apply the insets as a margin to the view. This solution sets
            // only the bottom, left, and right dimensions, but you can apply whichever
            // insets are appropriate to your layout. You can also update the view padding
            // if that's more appropriate.
            val params = v.layoutParams as ConstraintLayout.LayoutParams
            params.topMargin = insets.top
            v.layoutParams = params

            // Invalidate the layout to ensure the changes take effect
            v.requestLayout()

            // Return CONSUMED if you don't want want the window insets to keep passing
            // down to descendant views.
            WindowInsetsCompat.CONSUMED
        }
    }
}