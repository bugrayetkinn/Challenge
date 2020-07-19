package com.yetkin.mtekchallenge.module

import com.yetkin.mtekchallenge.data.remote.PharmacyAPI
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val pharmacyRetrofitModule = module {

    factory {
        Retrofit.Builder().baseUrl("https://eczaci-api.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    factory { get<Retrofit>().create(PharmacyAPI::class.java) }

}




