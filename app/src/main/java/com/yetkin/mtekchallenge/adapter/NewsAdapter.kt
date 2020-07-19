package com.yetkin.mtekchallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.yetkin.mtekchallenge.data.model.NewsModel
import com.yetkin.mtekchallenge.databinding.NewsCardBinding


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class NewsAdapter(

    private val setOnClickListener: (NewsModel) -> Unit
) : ListAdapter<NewsModel, NewsHolder>(DiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {

        val newsCardBinding: NewsCardBinding =
            NewsCardBinding.inflate(LayoutInflater.from(parent.context))

        return NewsHolder(newsCardBinding, parent.context)

    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.bind(getItem(position), setOnClickListener)
    }

    class DiffCallBack : DiffUtil.ItemCallback<NewsModel>() {
        override fun areItemsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean =
            oldItem.title == newItem.title


        override fun areContentsTheSame(oldItem: NewsModel, newItem: NewsModel): Boolean =
            oldItem == newItem

    }

}