package com.xxh.summary.lifecycle
/*
import android.os.Bundle
import android.util.Log
import com.xxh.summary.lifecycle.test.savedstate.SavedStateTest

class SavedStateTestActivity : BaseActivity<ActivitySavedStateTestBinding>() {

    private val test1 = SavedStateTest(this)

    override fun initBinding() {
        mBinding = ActivitySavedStateTestBinding.inflate(layoutInflater)
    }

    override fun initView() {
        super.initView()
        mBinding?.button?.setOnClickListener {
            test1.content=mBinding?.editText?.text.toString()
        }
        //不能放在onCreate回调方法中，因为Lifecycle.Event.ON_CREATE在onCreate之后
      */
/*  val str=test1.content
        mBinding?.textView2?.text = str+"dddd"*//*

    }

    override fun onStart() {
        super.onStart()
        val str=test1.content
        mBinding?.textView2?.text = str+"dddd"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i("xxh", "onSaveInstanceState")
        outState.putString(EDCONTENT1, mBinding?.editText?.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        mBinding?.textView?.text = savedInstanceState.getString(EDCONTENT1)
    }

    companion object {
        private const val EDCONTENT1 = "ed_content"
    }
}*/
