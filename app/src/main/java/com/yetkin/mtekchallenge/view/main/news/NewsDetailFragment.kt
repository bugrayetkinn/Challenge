package com.yetkin.mtekchallenge.view.main.news

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.yetkin.mtekchallenge.R
import com.yetkin.mtekchallenge.databinding.FragmentNewsDetailBinding
import com.yetkin.mtekchallenge.viewBinding

class NewsDetailFragment : Fragment(R.layout.fragment_news_detail) {

    lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        url = arguments?.getString("url", "google.com").toString()

    }

    private val detailBinding: FragmentNewsDetailBinding by viewBinding(FragmentNewsDetailBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailBinding.apply {

            webview.loadUrl(url)
            webview.webViewClient = WebViewClient()

            webview.webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    progressBar.visibility = View.VISIBLE
                    super.onPageStarted(view, url, favicon)
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    progressBar.visibility = View.GONE
                    super.onPageFinished(view, url)
                }
            }
        }

    }


}