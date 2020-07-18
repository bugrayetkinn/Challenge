package com.yetkin.mtekchallenge.repository

import androidx.lifecycle.MutableLiveData
import com.yetkin.mtekchallenge.data.model.PharmacyModel
import com.yetkin.mtekchallenge.data.remote.PharmacyAPI


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

class PharmacyRepository(private val pharmacyAPI: PharmacyAPI) {

    suspend fun getPharmacy(
        city: String,
        district: String
    ): MutableLiveData<List<PharmacyModel>> {

        val pharmacy = MutableLiveData<List<PharmacyModel>>()
        val response = pharmacyAPI.getPharmacys(city, district)

        if (response.isSuccessful) {
            pharmacy.value = response.body()?.data
        }
        return pharmacy
    }
}