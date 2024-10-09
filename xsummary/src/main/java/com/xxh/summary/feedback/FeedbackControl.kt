package com.xxh.summary.feedback

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.webkit.ValueCallback
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import com.xxh.summary.feedback.utils.FbLog
import com.xxh.summary.feedback.utils.FbServerUrls
import com.xxh.summary.feedback.utils.FeedbackJS
import com.xxh.summary.feedback.utils.WebType

object FeedbackControl {

    private var mUploadMessage: ValueCallback<Array<Uri>>? = null
    private var requestDataLauncher: ActivityResultLauncher<Intent>? = null

    @JvmOverloads
    fun getFeedbackView(context: ComponentActivity, type: WebType, url: String = ""): View {
        if (!FeedbackConfig.FbConfig.isInit) {
            throw Exception("FeedbackConfig is not init")
        }
        initActivityResult(context)
        if (type == WebType.PUSH_WEB && url.isEmpty()) {
            throw Exception("PUSH_WEB url is null")
        }
        return when (type) {
            WebType.HOME_WEB -> loadFeedbackHomeWeb(context)
            WebType.PUSH_WEB -> loadFeedbackPushWeb(context, url)
        }
    }

    private fun initActivityResult(activity: ComponentActivity) {
        requestDataLauncher =
            activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == AppCompatActivity.RESULT_OK) {
                    FbLog.d("FeedbackControl", "ActivityResultCallback" + result.data.toString())
                    if (mUploadMessage != null && result.data != null) {
                        val intent = result.data
                        if (intent?.data != null) {
                            val res = arrayOf(intent.data!!)
                            mUploadMessage!!.onReceiveValue(res)
                        } else {
                            mUploadMessage!!.onReceiveValue(null)
                        }
                    } else {
                        mUploadMessage?.onReceiveValue(null)
                    }
                } else {
                    mUploadMessage?.onReceiveValue(null)
                }
            }
    }


    private fun loadFeedbackHomeWeb(context: Context): View {
        val webView = initWebView(context)
        webView.loadUrl(FbServerUrls.getFeedbackHomeUrl())
        return webView
    }

    private fun loadFeedbackPushWeb(context: Context, url: String): View {
        val webView = initWebView(context)
        webView.loadUrl(url)
        return webView
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView(context: Context): WebView {
        val mWebView = WebView(context)
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
        if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
            if (FeedbackConfig.FbConfig.isDarkMode) {
                WebSettingsCompat.setForceDark(webSettings, WebSettingsCompat.FORCE_DARK_ON)
            } else {
                WebSettingsCompat.setForceDark(webSettings, WebSettingsCompat.FORCE_DARK_OFF)
            }
        }
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
                mUploadMessage = filePathCallback
                val intent = fileChooserParams?.createIntent()
                if (intent != null) {
                    requestDataLauncher?.launch(intent)
                }
                return true
            }
        }
        mWebView.addJavascriptInterface(
            FeedbackJS(
                context
            ), FeedbackJS.JS_NAME
        )
        return mWebView
    }


    fun destroy() {
        requestDataLauncher = null
        mUploadMessage = null
    }

    fun injectCSS(webView: WebView) {
        val code = "javascript:(function() {" +
                "var node = document.createElement('style');" +
                "node.type = 'text/css';" +
                " node.innerHTML = 'body, label,th,p,a, td, tr,li,ul,span,table,h1,h2,h3,h4,h5,h6,h7,div,small {" +
                "     color: #deFFFFFF;" +
                "background-color: #232323;" +
                " } ';" +
                " document.head.appendChild(node);})();"
        webView.evaluateJavascript(code, null)
    }

}

