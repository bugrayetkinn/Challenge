package com.yetkin.mtekchallenge.module

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

    factory { provideOkHttpClient() }
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

fun provideOkHttpClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
}

fun providePharmacyApi(retrofit: Retrofit): PharmacyAPI =
    retrofit.create(PharmacyAPI::class.java)


