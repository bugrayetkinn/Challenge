package com.yetkin.mtekchallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yetkin.mtekchallenge.data.model.NewsModel
import com.yetkin.mtekchallenge.databinding.NewsCardBinding


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class NewsAdapter(
    private val news: ArrayList<NewsModel>,
    private val setOnClickListener: (NewsModel) -> Unit
) :
    RecyclerView.Adapter<NewsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val newsCardBinding = NewsCardBinding.inflate(LayoutInflater.from(parent.context))
        return NewsHolder(newsCardBinding, parent.context)
    }

    override fun getItemCount(): Int = news.size

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bind(news[position], setOnClickListener)
    }

    fun addNews(news: ArrayList<NewsModel>) {
        this.news.apply {
            clear()
            addAll(news)
        }
    }

}