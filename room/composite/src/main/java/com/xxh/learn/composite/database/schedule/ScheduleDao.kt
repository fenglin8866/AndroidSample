package com.xxh.learn.composite.database.schedule

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface ScheduleDao {
    @Query("select * from schedule")
    fun getAllSchedule():LiveData<List<Schedule>>

    @Query("select * from schedule where stop_name=:stopName")
    fun getScheduleByStopName(stopName: String): LiveData<List<Schedule>>
}