package com.xxh.learn.demo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.xxh.learn.demo.databinding.ActivityMainBinding
import com.xxh.learn.demo.net.NetActivity


class MainActivity : AppCompatActivity() {

    private val viewModel: TestViewModel by viewModels {
        TestViewModel.Factory
    }
    private val viewModel2 by viewModels<TestViewModel> {
        TestViewModel.Factory
    }

    private var _binding: ActivityMainBinding? = null
    private val mBinding: ActivityMainBinding get() = _binding!!
    private val savedTestDataManager = SavedTestDataManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setUpView()
    }

    private fun setUpView() {
        mBinding.apply {
            button.setOnClickListener {
               // startActivity(Intent(this@MainActivity,WebViewActivity::class.java))
                //textView.text = viewModel.getApplication()
                /*val url = "https://developers.android.com"
                val intent = CustomTabsIntent.Builder().build()
                intent.launchUrl(this@MainActivity, Uri.parse(url))*/
                //Log.i("xxh00", Utils.getDeviceId())
                val intent = Intent(Intent.ACTION_VIEW)
                intent.setData(Uri.parse("https://developers.android.com"))
               // intent.setPackage("com.android.browser") // 需要手动指定浏览器
                startActivity(intent)
            }
            button2.setOnClickListener {
                startActivity(Intent(this@MainActivity,NetActivity::class.java))
                //textView2.text = viewModel.getSavedTest()
              //  editTextText.setText(savedTestDataManager.getTextData())
               // Log.i("xxh00", Utils.getDeviceId())
            }
            button3.setOnClickListener {
                //textView2.text = viewModel.getSavedTest()
                savedTestDataManager.setTextData(editTextText.text.toString())
            }
        }
    }
}