package com.xxh.learn.sample.compose

import android.content.Intent
import androidx.compose.material3.catalog.library.CatalogActivity
import com.example.android.roomwordssample.WordsActivity
import com.example.busschedule.BusScheduleActivity
import com.example.inventory.InventoryActivity
import com.xxh.basic.ListBaseFragment


class ComposeListFragment : ListBaseFragment(){
    override fun setData(): Array<String> = arrayOf(
        "m3",
    )

    override fun itemClickHandle(name: String) {
        val clazz: Class<*>? = when (name) {
            "m3" -> CatalogActivity::class.java
            else -> null
        }
        clazz?.let {
            startActivity(Intent(this.requireContext(),clazz))
        }
    }

}