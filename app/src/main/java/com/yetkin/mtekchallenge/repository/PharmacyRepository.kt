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
        val response = pharmacyAPI.getPharmacys(
            "apikey 2yzeSha9pxBhcV9KO3e8Nd:1bvFCKmaPFpSmy23F2KoiP",
            "application/json",
            city,
            district
        )

        if (response.isSuccessful) {
            if (response.body() != null) {
                Log.e("Response : ", "Not Empty")
            } else {
                Log.e("Response : ", "Empty")
            }
            if (response.body()?.result != null) {
                Log.e("Result : ", "Null değil")
            } else {
                Log.e("Result : ", "Null")
            }
            pharmacy.value = response.body()?.result
        }

        return pharmacy
    }
}