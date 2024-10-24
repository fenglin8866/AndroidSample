package com.xxh.learn.demo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.xxh.learn.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: TestViewModel by viewModels{
        TestViewModel.Factory
    }
    private val viewModel2 by viewModels<TestViewModel> {
        TestViewModel.Factory
    }

    private var _binding: ActivityMainBinding? = null
    private val mBinding: ActivityMainBinding get() = _binding!!
    private val savedTestDataManager=SavedTestDataManager(this)

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
                textView.text = viewModel.getApplication()
            }
            button2.setOnClickListener {
                //textView2.text = viewModel.getSavedTest()
                editTextText.setText(savedTestDataManager.getTextData())
            }
            button3.setOnClickListener {
                //textView2.text = viewModel.getSavedTest()
                savedTestDataManager.setTextData(editTextText.text.toString())
            }
        }
    }
}