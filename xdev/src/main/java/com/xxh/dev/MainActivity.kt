package com.xxh.dev

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.xxh.dev.databinding.ActivityMainBinding
import com.xxh.dev.service.TestService
import com.xxh.dev.utils.CommonUtils

class MainActivity : AppCompatActivity() {

    private  var _Binding: ActivityMainBinding? = null
    private val mBinding: ActivityMainBinding
        get() = _Binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _Binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mBinding.apply {
            button.setOnClickListener {
               /* val intent= Intent(this@MainActivity,TestService::class.java)
                stopService(intent)
                startService(intent)*/
                CommonUtils.simInfo()
            }
            button2.setOnClickListener{
                val intent= Intent(this@MainActivity,TestService::class.java)
                stopService(intent)
            }


        }
    }
}