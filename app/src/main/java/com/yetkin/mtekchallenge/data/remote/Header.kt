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
                        "apikey 2yzeSha9pxBhcV9KO3e8Nd:1bvFCKmaPFpSmy23F2KoiP"
                    )
                    .addHeader(
                        "Content-Type", "application/json"
                    ).build()
            )
        }
    }
}