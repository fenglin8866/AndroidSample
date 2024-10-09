package com.xxh.learn.sample.lang

import com.example.busschedule.BusScheduleActivity
import com.example.inventory.InventoryActivity
import com.xxh.basic.ListBaseFragment
import com.xxh.learn.java.JavaTestMain
import com.xxh.learn.kotlin.KotlinTestMain


class LangListFragment : ListBaseFragment(){
    override fun setData(): Array<String> = arrayOf(
        "Kotlin",
        "Java",
    )

    override fun itemClickHandle(name: String) {
       when (name) {
            "Kotlin" -> KotlinTestMain.kotlinMain()
            "Java" -> JavaTestMain.javaMain()
        }
    }

}