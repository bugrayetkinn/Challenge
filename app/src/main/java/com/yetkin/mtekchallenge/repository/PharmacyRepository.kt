package com.yetkin.mtekchallenge.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.yetkin.mtekchallenge.data.model.PharmacyModel
import com.yetkin.mtekchallenge.data.remote.PharmacyAPI


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

class PharmacyRepository(private val pharmacyAPI: PharmacyAPI) {

    suspend fun getData(
        city: String,
        district: String
    ): MutableLiveData<List<PharmacyModel>> {

        val pharmacy = MutableLiveData<List<PharmacyModel>>()
        val response = pharmacyAPI.getPharmacys(city, district)

        if (response.isSuccessful) {
            pharmacy.value = response.body()?.result
        }
        Log.e("Status : ", "" + (pharmacy.value?.size ?: 0))
        return pharmacy
    }
}