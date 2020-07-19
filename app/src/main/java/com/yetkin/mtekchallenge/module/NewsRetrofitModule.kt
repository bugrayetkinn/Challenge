package com.yetkin.mtekchallenge.module

import com.yetkin.mtekchallenge.data.remote.NewsAPI
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val newsRetrofitModule = module {

    single {
        named("news")
        createWebService<NewsAPI>("https://newsapi.org")
    }
}

inline fun <reified T> createWebService(
    baseUrl: String
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create()).build()
    return retrofit.create(T::class.java)
}