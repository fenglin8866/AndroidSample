package com.xxh.learn.sample

import android.content.Intent
import com.xxh.basic.ListBaseActivity
import com.xxh.learn.sample.di.DIMainActivity
import com.xxh.learn.sample.room.RoomMainActivity


class MainActivity : ListBaseActivity() {

    override fun setData(): Array<String> = arrayOf(
        "Room",
        "DI",
        "Lifecycle",
        "Navigation",
        "SunFlower",
        "Todo",

    )

    override fun setClickIntent(name: String): Intent? = when (name) {
        "Room" -> Intent(this, RoomMainActivity::class.java)
        "DI" -> Intent(this, DIMainActivity::class.java)
        else -> null
    }
}
