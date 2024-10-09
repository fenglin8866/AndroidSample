package com.xxh.summary

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.xxh.summary.feedbacktest.FeedbackMainActivity
import com.xxh.summary.share.ShareActivity
import com.xxh.summary.viewpage.ViewPagerActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.button).setOnClickListener{
            startActivity(Intent(this,ShareActivity::class.java))
        }
    }

    fun test(){
            val content=""
            var intent: Intent? = null
            when (content) {
                "ViewPager" -> intent = Intent(this, ViewPagerActivity2::class.java)
//                "LogSave" -> intent = Intent(context, LogActivity::class.java)
                "LogSave" -> intent = Intent(this, FeedbackMainActivity::class.java)
                "CloudDev" -> {
                    intent = Intent()
                    val toActivity =
                        ComponentName("cn.nubia.cloud", "cn.nubia.cloud.dev.DevModeActivity")
                    intent.component = toActivity

                }

                "DeepLink" -> {
//                    val url="hap://app/com.application.qc_mobike"
                    val url2 = "browser://cn.nubia.browser/search?words=搜索词"
                    /*    val i=Intent("cn.nubia.quickrt.action.LAUNCH")
                        i.putExtra("EXTRA_APP","cn.badmannb.douping")*/
                    //  val i= i0.setData(Uri.parse(url))
                    intent = Intent.parseUri(url2, Intent.URI_INTENT_SCHEME)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                }
            }
            intent?.let {
                ContextCompat.startActivity(this, intent, null)
            }
    }

}