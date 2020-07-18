package com.yetkin.mtekchallenge.data.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

class DistrictList {
    @SerializedName("districtDetail")
    val districtDetail: List<District> = ArrayList()
}

data class District(
    @SerializedName("IlceAdi") val ilceAdi: String,
    @SerializedName("SehirID") val sehirId: String,
    @SerializedName("IlceAdiEn") val ilceAdiEn: String,
    @SerializedName("IlceID") val ilceID: String
)