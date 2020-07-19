package com.yetkin.mtekchallenge.data.remote

import com.yetkin.mtekchallenge.data.model.PharmacyModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
interface PharmacyAPI {

    @GET("/get/{city}/{district}")
    suspend fun getPharmacys(
        @Path("city") city: String,
        @Path("district") district: String
    ): Response<List<PharmacyModel>>
}