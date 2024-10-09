package com.xxh.summary.feedbacktest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xxh.summary.databinding.ActivityFeedbackMainBinding

class FeedbackMainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityFeedbackMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityFeedbackMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mBinding.feedback.setOnClickListener {
            startActivity(Intent(this, FeedbackTestActivity::class.java))
        }
        mBinding.push.setOnClickListener {
            val pushUrl = "https://browser-test.server.nubia.cn/ba/getReplyDetail.do?fid=9232"
            val intent = Intent(this, FeedbackTestActivity::class.java)
            intent.putExtra(PUSH_FEEDBACK_URL, pushUrl)
            startActivity(intent)
        }
    }
}