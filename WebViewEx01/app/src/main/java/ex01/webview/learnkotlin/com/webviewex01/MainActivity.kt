package ex01.webview.learnkotlin.com.webviewex01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        webview1.getSettings().setJavaScriptEnabled(true)
        webview1.webViewClient = WebViewClient()
        webview1.loadUrl("https://www.google.com/")


    }
}
