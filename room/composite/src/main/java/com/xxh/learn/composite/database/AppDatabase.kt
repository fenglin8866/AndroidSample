package com.xxh.learn.composite.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.xxh.learn.composite.database.schedule.Schedule
import com.xxh.learn.composite.database.schedule.ScheduleDao

@Database(entities = [Schedule::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "RoomDatabase"
                ).createFromAsset("database/bus_schedule.db").build()
                INSTANCE = instance
                instance
            }
        }
    }
}