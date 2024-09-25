package com.xxh.learn.sample

import android.content.Intent
import com.xxh.basic.ListBaseActivity


class MainActivity : ListBaseActivity() {

    override fun setData(): Array<String> = arrayOf(
        "Lifecycle",
        "IOC",
        "Room",
        "Navigation",
        "SunFlower",
        "Todo",

    )

    override fun setClickIntent(name: String): Intent? = when (name) {
       /* "Lifecycle" -> Intent(this, MainActivity::class.java)
        "IOC" -> Intent(this, IocMainActivity::class.java)
        "Room" -> Intent(this, RoomMainActivity::class.java)
        "Navigation" -> Intent(this, NavigationMainActivity::class.java)
        "SunFlower" -> Intent(this, GardenActivity::class.java)
        "Todo" -> Intent(this, TasksActivity::class.java)*/
        else -> null
    }
}
