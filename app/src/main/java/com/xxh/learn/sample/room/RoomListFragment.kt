package com.xxh.learn.sample.room

import android.content.Intent
import com.example.android.roomwordssample.WordsActivity
import com.example.busschedule.BusScheduleActivity
import com.example.inventory.InventoryActivity
import com.xxh.basic.ListBaseFragment


class RoomListFragment : ListBaseFragment(){
    override fun setData(): Array<String> = arrayOf(
        "BusSchedule",
        "Inventory",
        "Words",
    )

    override fun itemClickHandle(name: String) {
        val clazz: Class<*>? = when (name) {
            "BusSchedule" -> BusScheduleActivity::class.java
            "Inventory" -> InventoryActivity::class.java
            "Words" -> WordsActivity::class.java
            else -> null
        }
        clazz?.let {
            startActivity(Intent(this.requireContext(),clazz))
        }
    }

}