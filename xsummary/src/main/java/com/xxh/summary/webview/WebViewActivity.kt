package com.xxh.summary.webview

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.xxh.summary.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private var _binding: ActivityWebViewBinding? = null
    private val mBinding get() = _binding!!
    private lateinit var mWebView: WebView
    private var urlStr: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindView(layoutInflater)
        urlStr = intent.getStringExtra(URL_KEY)
        setContentView(mBinding.root)
        setupViews()
    }

    private fun bindView(inflater: LayoutInflater): ActivityWebViewBinding {
        return ActivityWebViewBinding.inflate(inflater)
    }

    private fun setupViews() {
        initWebView()
        if (!urlStr.isNullOrEmpty()) {
            mWebView.loadUrl(urlStr!!)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        mWebView = mBinding.webView
        val webSettings = mWebView.settings
        webSettings.domStorageEnabled = true
        webSettings.databaseEnabled = true
        webSettings.javaScriptEnabled = true
        webSettings.useWideViewPort = true
        webSettings.allowFileAccess = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.loadsImagesAutomatically = true
        webSettings.setGeolocationEnabled(true)
        webSettings.loadWithOverviewMode = true
        webSettings.mediaPlaybackRequiresUserGesture = false
        webSettings.defaultTextEncodingName = "UTF-8"
        webSettings.setSupportMultipleWindows(true)
        mWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }

        }

        mWebView.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView?,
                filePathCallback: ValueCallback<Array<Uri>>?,
                fileChooserParams: FileChooserParams?
            ): Boolean {
                return true
            }
        }
    }

    companion object {
        const val URL_KEY = "url_key"
    }
}