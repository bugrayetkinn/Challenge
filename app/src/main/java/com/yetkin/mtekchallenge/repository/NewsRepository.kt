package com.yetkin.mtekchallenge.repository

import androidx.lifecycle.MutableLiveData
import com.yetkin.mtekchallenge.data.model.NewsListModel
import com.yetkin.mtekchallenge.data.model.NewsModel
import com.yetkin.mtekchallenge.data.remote.NewsAPI
import retrofit2.Response
import java.util.ArrayList


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class NewsRepository(private val newsAPI: NewsAPI) {

    suspend fun getData(): MutableLiveData<List<NewsModel>> {

        val data: MutableLiveData<List<NewsModel>> = MutableLiveData()
        val response = newsAPI.getData()

        if (response.isSuccessful) {
            data.value = response.body()?.data
        }
        return data
    }
}