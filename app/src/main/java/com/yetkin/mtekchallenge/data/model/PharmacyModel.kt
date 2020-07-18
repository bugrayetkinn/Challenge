package com.yetkin.mtekchallenge.data.model

import com.google.gson.annotations.SerializedName


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
data class PharmacyModel(
    @SerializedName("name") val name: String,
    @SerializedName("dist") val dist: String,
    @SerializedName("address") val address: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("loc") val loc: String
)