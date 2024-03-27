package com.canque.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.canque.myapplication.dao_interfaces.StudentDao
import com.canque.myapplication.models.Student

@Database(entities = [Student::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "student_database"
                )
                    // Add migration strategy here if needed
                    .fallbackToDestructiveMigration() // Example: Destructive migration
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}