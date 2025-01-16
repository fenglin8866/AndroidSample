package com.xxh.learn.composite.busschedule.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.xxh.learn.composite.database.schedule.Schedule
import com.xxh.learn.composite.database.schedule.ScheduleDao
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class ScheduleListViewModel(private val scheduleDao: ScheduleDao) : ViewModel() {

    fun getFullSchedule(): LiveData<List<Schedule>> {
        return scheduleDao.getAllSchedule()
    }

    fun getStopSchedule(stopName: String): LiveData<List<Schedule>> {
        return scheduleDao.getScheduleByStopName(stopName)
    }

}