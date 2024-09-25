package com.xxh.learn.sample

import android.content.Intent
import com.xxh.basic.ListBaseActivity
import com.xxh.learn.sample.room.RoomMainActivity


class MainActivity : ListBaseActivity() {

    override fun setData(): Array<String> = arrayOf(
        "Room",
        "Lifecycle",
        "IOC",
        "Navigation",
        "SunFlower",
        "Todo",

    )

    override fun setClickIntent(name: String): Intent? = when (name) {
        "Room" -> Intent(this, RoomMainActivity::class.java)
        else -> null
    }
}
