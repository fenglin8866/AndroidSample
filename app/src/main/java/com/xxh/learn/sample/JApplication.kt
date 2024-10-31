package com.xxh.learn.sample

import android.app.Application
import com.xxh.basic.IComponentApplication
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class JApplication:Application() {
    private val MODULESLIST: Array<String> = arrayOf(
        "com.example.busschedule.BusScheduleApplication",
        "com.example.inventory.InventoryApplication",
        "com.example.android.roomwordssample.WordsApplication",
        "com.example.android.architecture.blueprints.todoapp.TodoApplication",
        "com.example.android.persistence.BasicApplication"
    )

    override fun onCreate() {
        super.onCreate()
        modulesApplicationInit()
    }

    private fun modulesApplicationInit(){
        for (moduleImpl in MODULESLIST) {
            try {
                val clazz = Class.forName(moduleImpl)
                val obj = clazz.newInstance()
                if (obj is IComponentApplication) {
                    obj.init(this)
                }
            } catch (e: ClassNotFoundException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: InstantiationException) {
                e.printStackTrace()
            }
        }
    }


}