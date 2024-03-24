package com.canque.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.canque.myapplication.constants.Constants
import com.canque.myapplication.databinding.ActivityStudentDetailsBinding

class StudentDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val studentName = intent.getStringExtra(Constants.PARAM_FIRST_NAME) + " " + intent.getStringExtra(Constants.PARAM_LAST_NAME)
        val studentId = intent.getIntExtra(Constants.PARAM_STUDENT_ID, 0)
        val studentPhoneNum = intent.getStringExtra(Constants.PARAM_PHONE_NUM)

        binding.name.setText(studentName)
        binding.studentId.setText(studentId.toString())
        binding.phoneNum.setText(studentPhoneNum)
    }
}