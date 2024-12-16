package com.example.dagger

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var student: Student

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        /**
         * AndroidInjection.inject（） 从应用程序获取一个DispatchingAndroidInjector<Object> ，
         * 并将activity 传递给 inject（Activity）。这 DispatchingAndroidInjector 查找 Activity 的类（即 YourActivitySubcomponent.Factory ）的 AndroidInjector.Factory ，
         * 创建 AndroidInjector（即 YourActivitySubcomponent），并将你的 activity 传递给 inject（YourActivity）。
         */
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        student.say("xxx")
        findViewById<Button>(R.id.button3).setOnClickListener{
            startActivity(Intent(this, YourActivity::class.java))
        }
    }
}