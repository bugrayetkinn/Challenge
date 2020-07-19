package com.yetkin.mtekchallenge.data.model

import com.google.gson.annotations.SerializedName


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
data class PharmacyListModel(
    @SerializedName("result") val result: List<PharmacyModel>,
    @SerializedName("success") val success: Boolean
)