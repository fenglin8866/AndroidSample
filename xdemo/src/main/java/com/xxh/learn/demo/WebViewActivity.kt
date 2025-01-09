package com.xxh.learn.demo

import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceError
import androidx.appcompat.app.AppCompatActivity
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewActivity : AppCompatActivity() {


    private lateinit var webView: WebView
    private val failedUrls = mutableSetOf<String>() // 用于记录加载失败的 URL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true

        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView,
                request: WebResourceRequest,
                error: WebResourceError
            ) {
                val failingUrl = request.url.toString()
                if (failingUrl == "https://wifi.airchina.com/") {
                    failedUrls.add(failingUrl) // 记录失败的 URL
                    webView.loadUrl("http://wifi.airchina.com/") // 加载备用 URL
                }
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                // 如果备用 URL 加载成功，可以清理失败 URL
                if (url == "http://wifi.airchina.com/") {
                    failedUrls.remove("https://wifi.airchina.com/")
                }
            }
        }

        // 初始加载 URL
        webView.loadUrl("https://wifi.airchina.com/")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            // 跳过失败的 URL
            if (shouldSkipUrl(-1)) {
                webView.goBackOrForward(-2) // 跳过上一页
            } else {
                webView.goBack()
            }
        } else {
            super.onBackPressed() // 退出 Activity
        }
    }

    fun goForward() {
        if (webView.canGoForward()) {
            // 跳过失败的 URL
            if (shouldSkipUrl(1)) {
                webView.goBackOrForward(2) // 跳过下一页
            } else {
                webView.goForward()
            }
        }
    }

    private fun shouldSkipUrl(offset: Int): Boolean {
        val history = webView.copyBackForwardList()
        val newIndex = history.currentIndex + offset
        if (newIndex >= 0 && newIndex < history.size) {
            val targetUrl = history.getItemAtIndex(newIndex).url
            return targetUrl in failedUrls
        }
        return false
    }
}