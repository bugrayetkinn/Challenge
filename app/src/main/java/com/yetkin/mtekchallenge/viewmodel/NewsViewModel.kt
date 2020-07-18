package com.yetkin.mtekchallenge.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yetkin.mtekchallenge.data.model.NewsModel
import com.yetkin.mtekchallenge.repository.NewsRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.e("Exception : ", throwable.localizedMessage)
        }

    fun getData(): MutableLiveData<List<NewsModel>> {

        val data: MutableLiveData<List<NewsModel>> = MutableLiveData()

        viewModelScope.launch(coroutineExceptionHandler) {
            data.value = newsRepository.getData().value
        }
        return data
    }
}