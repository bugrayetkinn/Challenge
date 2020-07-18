package com.yetkin.mtekchallenge.data.remote

import com.yetkin.mtekchallenge.data.model.PharmacyListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
interface PharmacyAPI {

    @GET("dutyPharmacy")
    suspend fun getPharmacys(
        @Query("city") city: String,
        @Query("distict") district: String
    ): Response<PharmacyListModel>
}