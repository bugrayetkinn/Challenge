package com.yetkin.mtekchallenge.data.remote

import com.yetkin.mtekchallenge.data.model.PharmacyListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
interface PharmacyAPI {

    @GET("dutyPharmacy")
    suspend fun getPharmacys(
        @Header("authorization") auth: String,
        @Header("content-type") contentType: String,
        @Query("city") city: String,
        @Query("district") district: String
    ): Response<PharmacyListModel>
}