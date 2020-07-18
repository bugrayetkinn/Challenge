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

    factory {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    factory {
        get<Retrofit>().create(NewsAPI::class.java)
    }
}