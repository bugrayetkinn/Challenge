package com.yetkin.mtekchallenge.data.remote

import com.yetkin.mtekchallenge.data.model.NewsListModel
import retrofit2.Response
import retrofit2.http.GET

/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
interface NewsAPI {

    @GET("/v2/top-headlines?country=us&apiKey=c668516fbbf9448bbd78bafafa1716fb")
    suspend fun getData(): Response<NewsListModel>
}