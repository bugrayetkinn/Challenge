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

    factory { Header() }
    factory { provideOkHttpClient(get()) }
    factory { providePharmacyApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://api.collectapi.com/health/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(header: Header): OkHttpClient {
    return OkHttpClient.Builder().addInterceptor(header)
        .addInterceptor(HttpLoggingInterceptor()).build()
}

fun providePharmacyApi(retrofit: Retrofit): PharmacyAPI =
    retrofit.create(PharmacyAPI::class.java)


