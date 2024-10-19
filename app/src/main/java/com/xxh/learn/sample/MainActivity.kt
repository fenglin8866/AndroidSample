package com.xxh.learn.sample

import android.content.Intent
import com.xxh.basic.ListBaseActivity
import com.xxh.learn.sample.compose.ComposeMainActivity
import com.xxh.learn.sample.di.DIMainActivity
import com.xxh.learn.sample.lang.LangMainActivity
import com.xxh.learn.sample.room.RoomMainActivity
import com.xxh.learn.sample.sample.SampleMainActivity


class MainActivity : ListBaseActivity() {

    override fun setData(): Array<String> = arrayOf(
        "Lang",
        "Room",
        "DI",
        "Lifecycle",
        "Navigation",
        "Compose",
        "Sample",
    )

    override fun setClickIntent(name: String): Intent? = when (name) {
        "Room" -> Intent(this, RoomMainActivity::class.java)
        "DI" -> Intent(this, DIMainActivity::class.java)
        "Lang" -> Intent(this, LangMainActivity::class.java)
        "Compose" -> Intent(this, ComposeMainActivity::class.java)
        "Sample" -> Intent(this, SampleMainActivity::class.java)
        else -> null
    }
}
