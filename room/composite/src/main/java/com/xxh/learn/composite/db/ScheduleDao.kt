package com.xxh.learn.composite.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.xxh.learn.composite.vo.Schedule

@Dao
interface ScheduleDao {
    @Query("select * from Schedule")
    fun getAllSchedule():LiveData<List<Schedule>>

    @Query("select * from Schedule where stop_name=:stopName")
    fun getScheduleByStopName(stopName: String): LiveData<List<Schedule>>
}