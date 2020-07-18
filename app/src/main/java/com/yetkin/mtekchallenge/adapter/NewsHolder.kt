package com.yetkin.mtekchallenge.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yetkin.mtekchallenge.data.model.NewsModel
import com.yetkin.mtekchallenge.databinding.NewsCardBinding

/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class NewsHolder(private val newsCardBinding: NewsCardBinding, val context: Context) :
    RecyclerView.ViewHolder(newsCardBinding.root) {

    fun bind(newsModel: NewsModel, setOnClikListener: (NewsModel) -> Unit) {
        newsCardBinding.apply {
            Glide.with(context).load(newsModel.urlToImage).into(imageView)
            textViewTitle.text = newsModel.title
            textViewAuthor.text = newsModel.author

            root.setOnClickListener {
                setOnClikListener(newsModel)
            }
        }
    }

}