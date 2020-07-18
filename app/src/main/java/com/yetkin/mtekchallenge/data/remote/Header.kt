package com.yetkin.mtekchallenge.data.remote

import okhttp3.Interceptor
import okhttp3.Response


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class Header : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.run {
            proceed(
                request().newBuilder()
                    .addHeader(
                        "authorization",
                        "apikey 617enD1R2dqYyvqUdVEE3X:2T1OI3vB38vWrPLYsJFfZb"
                    )
                    .addHeader(
                        "Content-Type", "application/json"
                    ).build()
            )
        }
    }
}