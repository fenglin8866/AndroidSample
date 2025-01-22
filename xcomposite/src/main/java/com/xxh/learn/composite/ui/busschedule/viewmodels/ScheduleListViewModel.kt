package com.xxh.learn.composite.ui.busschedule.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.xxh.learn.composite.vo.Schedule
import com.xxh.learn.composite.repository.ScheduleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleListViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository
) : ViewModel() {

    fun getFullSchedule(): LiveData<List<Schedule>> {
        return scheduleRepository.getFullSchedule()
    }

    fun getStopSchedule(stopName: String?): LiveData<List<Schedule>>? {
        return scheduleRepository.getStopSchedule(stopName)
    }

}