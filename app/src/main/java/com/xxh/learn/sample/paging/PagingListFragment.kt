package com.xxh.learn.sample.paging

import android.content.Intent
import com.android.example.paging.pagingwithnetwork.SampleWithNetWorkActivity
import com.example.android.roomwordssample.WordsActivity
import com.example.busschedule.BusScheduleActivity
import com.example.inventory.InventoryActivity
import com.xxh.basic.ListBaseFragment
import paging.android.example.com.pagingsample.CheeseActivity


class PagingListFragment : ListBaseFragment(){
    override fun setData(): Array<String> = arrayOf(
        "Sample",
        "SampleWithNetwork",
    )

    override fun itemClickHandle(name: String) {
        val clazz: Class<*>? = when (name) {
            "Sample" -> CheeseActivity::class.java
            "SampleWithNetwork" -> SampleWithNetWorkActivity::class.java
            else -> null
        }
        clazz?.let {
            startActivity(Intent(this.requireContext(),clazz))
        }
    }

}