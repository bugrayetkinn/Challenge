package com.yetkin.mtekchallenge.data.model

import com.google.gson.annotations.SerializedName


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
data class NewsModel(
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("urlToImage")
    val urlToImage: String
)