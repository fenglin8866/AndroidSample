package com.xxh.learn.composite.repository

import androidx.lifecycle.LiveData
import com.xxh.learn.composite.db.ScheduleDao
import com.xxh.learn.composite.vo.Schedule
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScheduleRepository @Inject constructor(private val scheduleDao: ScheduleDao) {

    fun getFullSchedule(): LiveData<List<Schedule>> {
        return scheduleDao.getAllSchedule()
    }

    fun getStopSchedule(stopName: String?): LiveData<List<Schedule>>? {
        if (stopName != null) {
            return scheduleDao.getScheduleByStopName(stopName)
        }
        return null
    }
}