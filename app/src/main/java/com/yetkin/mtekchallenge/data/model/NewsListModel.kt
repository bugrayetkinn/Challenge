package com.yetkin.mtekchallenge.data.model

import com.google.gson.annotations.SerializedName


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
data class NewsListModel(
    @SerializedName("articles")
    val data: List<NewsModel>
)