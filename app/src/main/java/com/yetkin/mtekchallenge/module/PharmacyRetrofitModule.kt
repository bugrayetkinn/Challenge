package com.yetkin.mtekchallenge.module

import com.yetkin.mtekchallenge.data.remote.Header
import com.yetkin.mtekchallenge.data.remote.PharmacyAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val pharmacyRetrofitModule = module {

    single {
        val logging = HttpLoggingInterceptor()
        val header = Header()
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(header)
            .build()
        Retrofit.Builder().baseUrl("https://api.collectapi.com/health/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    single {
        get<Retrofit>().create(PharmacyAPI::class.java)
    }

}