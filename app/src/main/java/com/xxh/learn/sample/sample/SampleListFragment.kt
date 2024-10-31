package com.xxh.learn.sample.sample

import android.content.Intent
import com.android.example.github.BrowserMainActivity
import com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity
import com.example.android.persistence.ui.PersistenceActivity
import com.google.samples.apps.sunflower.GardenActivity
import com.xxh.basic.ListBaseFragment


class SampleListFragment : ListBaseFragment(){
    override fun setData(): Array<String> = arrayOf(
        "Basic",
        "GithubBrowser",
        "SunFlow",
        "ToDo",
    )

    override fun itemClickHandle(name: String) {
        val clazz: Class<*>? = when (name) {
            "Basic" -> PersistenceActivity::class.java
            "GithubBrowser" -> BrowserMainActivity::class.java
            "SunFlow" -> GardenActivity::class.java
            "ToDo" -> TasksActivity::class.java
            else -> null
        }
        clazz?.let {
            startActivity(Intent(this.requireContext(),clazz))
        }
    }

}