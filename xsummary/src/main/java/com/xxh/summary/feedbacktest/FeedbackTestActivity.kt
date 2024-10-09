package com.xxh.summary.feedbacktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_BACK
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.webkit.WebView
import com.xxh.summary.databinding.ActivityFeedbackBinding
import com.xxh.summary.feedback.FeedbackConfig
import com.xxh.summary.feedback.FeedbackControl
import com.xxh.summary.feedback.utils.DeviceIdType
import com.xxh.summary.feedback.utils.WebType


class FeedbackTestActivity : AppCompatActivity(), OnClickListener {
    private lateinit var mBinding: ActivityFeedbackBinding
    private var mFeedbackView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding= ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.back.setOnClickListener(this)
        init()
    }

   private fun init() {
        FeedbackConfig.Builder()
            /**
             * 必选参数：用于标识用户和客服回复消息后推送,
             * 一般为VAID或OAID.
             * setDeviceId(DeviceIdType.VAID, "xxxxxxx")或 setDeviceId(DeviceIdType.OAID, "xxxxxxx")
             */
            .setDeviceId(DeviceIdType.OAID, "xxxxxxx")
            /**
             * 以下为可选参数，可以不用设置，使用默认值
             */
            .setDebug(true)
            .build()

        val mUrl = intent.getStringExtra(PUSH_FEEDBACK_URL)
        mFeedbackView = if (mUrl.isNullOrEmpty()) {
            //用户反馈主界面
            FeedbackControl.getFeedbackView(this, WebType.HOME_WEB) as WebView
        } else {
            //push通知点击跳转页面
            FeedbackControl.getFeedbackView(this, WebType.PUSH_WEB,mUrl) as WebView
        }
        mBinding.containerView.addView(mFeedbackView)
    }

    override fun onDestroy() {
        FeedbackControl.destroy()
        if (mFeedbackView != null) {
            (mFeedbackView?.parent as ViewGroup).removeView(mFeedbackView)
            mFeedbackView?.destroy()
            mFeedbackView = null
        }
        super.onDestroy()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KEYCODE_BACK) {
            if (mFeedbackView?.canGoBack() == true) {
                mFeedbackView?.goBack()
                return true
            }

        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onClick(v: View?) {
        if (mFeedbackView?.canGoBack() == true) {
            mFeedbackView?.goBack()
        } else {
            finish()
        }
    }

}
