package com.xxh.learn.system.component.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xxh.learn.system.component.R

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
       /* if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, TestFragment.newInstance())
                .commitNow()
        }*/
    }
}