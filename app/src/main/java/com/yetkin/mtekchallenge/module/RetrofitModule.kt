package com.yetkin.mtekchallenge.module

import com.yetkin.mtekchallenge.data.remote.NewsAPI
import com.yetkin.mtekchallenge.data.remote.PharmacyAPI
import com.yetkin.mtekchallenge.repository.NewsRepository
import com.yetkin.mtekchallenge.repository.PharmacyRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val retrofitModule = module {

    single(named("newsModules")) {
        createWebService<NewsAPI>("https://newsapi.org")
    }
    factory<NewsRepository> { NewsRepository(get(named("newsModules"))) }

    single(named("pharmacyModules")) {
        createWebService<PharmacyAPI>("https://eczaci-api.herokuapp.com")
    }
    factory<PharmacyRepository> { PharmacyRepository(get(named("pharmacyModules"))) }
}

inline fun <reified T> createWebService(
    baseUrl: String
): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create()).build()
    return retrofit.create(T::class.java)
}