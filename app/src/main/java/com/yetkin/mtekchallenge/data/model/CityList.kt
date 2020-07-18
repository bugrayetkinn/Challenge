package com.yetkin.mtekchallenge.data.model

import com.google.gson.annotations.SerializedName
import java.util.ArrayList


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class CityList {

    @SerializedName("cityDetail")
    val cityDetail: List<City> = ArrayList()
}

data class City(
    @SerializedName("SehirAdi") val sehirAdi: String,
    @SerializedName("SehirAdiEn") val sehirAdiEn: String,
    @SerializedName("SehirID") val sehirId: String
)