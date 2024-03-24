package com.canque.myapplication.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canque.myapplication.StudentDetailsActivity
import com.canque.myapplication.constants.Constants
import com.canque.myapplication.databinding.ItemStudentBinding
import com.canque.myapplication.models.Student

class StudentAdapter(
    private val activity: Activity,
    private val students: MutableList<Student>
): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(
        private val activity: Activity,
        private val binding: ItemStudentBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.fNameTextView.text = student.fName
            binding.lNameTextView.text = student.lName
            binding.row.setOnClickListener {

                // Declaring Intent.
                val intent = Intent(
                    activity, // Context of the Current Activity.
                    StudentDetailsActivity::class.java // Activity that we want to open.
                )

                intent.putExtra(Constants.PARAM_STUDENT_ID, student.id)
                intent.putExtra(Constants.PARAM_FIRST_NAME, student.fName)
                intent.putExtra(Constants.PARAM_LAST_NAME, student.lName)
                intent.putExtra(Constants.PARAM_PHONE_NUM, student.phoneNum)

                // Open the ProfileActivity.
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return StudentViewHolder(activity, binding)
    }

    override fun getItemCount() = students.size

    override fun onBindViewHolder(
        holder: StudentViewHolder,
        position: Int
    ) {
        holder.bind(students[position])
    }
}