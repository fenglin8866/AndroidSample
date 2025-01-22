/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xxh.learn.composite.ui.busschedule

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.xxh.learn.composite.vo.Schedule
import com.xxh.learn.composite.databinding.ItemScheduleBinding
import com.xxh.learn.composite.ui.busschedule.ScheduleAdapter.ScheduleViewHolder
import java.text.SimpleDateFormat
import java.util.Date

class ScheduleAdapter(private val clickCallback: ((Schedule) -> Unit)? = null) :
    ListAdapter<Schedule, ScheduleViewHolder>(SCHEDULE_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        return ScheduleViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.bind(getItem(position), clickCallback)
    }

    companion object {
        private val SCHEDULE_COMPARATOR = object : DiffUtil.ItemCallback<Schedule>() {
            override fun areItemsTheSame(
                old: Schedule,
                schedule: Schedule
            ): Boolean {
                return old.id == schedule.id
            }

            override fun areContentsTheSame(
                old: Schedule,
                schedule: Schedule
            ): Boolean {
                return old.id == schedule.id && old.stopName == schedule.stopName
                        && old.arrivalTime == schedule.arrivalTime
            }
        }
    }

    class ScheduleViewHolder(private val binding: ItemScheduleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SimpleDateFormat")
        fun bind(entity: Schedule, clickCallback: ((Schedule) -> Unit)?) {
            binding.apply {
                stopName.text = entity.stopName
                arrivalTime.text = SimpleDateFormat("h:mm a").format(
                    Date(entity.arrivalTime.toLong() * 1000)
                )
                itemView.setOnClickListener {
                    clickCallback?.let { callback ->
                        callback(entity)
                    }
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): ScheduleViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemScheduleBinding.inflate(layoutInflater, parent, false)
                return ScheduleViewHolder(binding)
            }
        }
    }

}
