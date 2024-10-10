package com.xxh.summary.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.xxh.summary.R
import com.xxh.summary.databinding.ActivityLayoutBinding
import com.xxh.summary.databinding.ItemMainBinding
import com.xxh.summary.databinding.ItemOther1Binding
import com.xxh.summary.databinding.ItemOther3Binding

class LayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        testMerge()
    }

    private fun testInclude() {
        //included中定义id，自动生成binding视图，获取对应的元素
        binding = ActivityLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.itemLayout.name.text = "include3"

        //include没有定义id，通过binding视图，获取对应的元素
        val includeBinding = ItemMainBinding.bind(binding.root)
        includeBinding.name.text = "include2"

        //通过findViewById查找include中元素
        setContentView(R.layout.activity_layout)
        findViewById<TextView>(R.id.name).text = "include"
        findViewById<TextView>(R.id.buttonItem).text = "btn"
    }

    //使用merge的include不能定义Id
    private fun testMerge() {
        val includeOther1Binding = ItemOther1Binding.bind(binding.root)
        includeOther1Binding.buttonItem1.text = "merge"
        includeOther1Binding.buttonItem1.setOnClickListener {
            testViewStub()
        }
    }

    private fun testViewStub() {
        val view = binding.viewStub2.inflate()
        val itemOther3 = ItemOther3Binding.bind(view)
        itemOther3.textView3.text="测试ViewStub"
    }

}