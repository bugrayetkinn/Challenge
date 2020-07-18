package com.yetkin.mtekchallenge.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yetkin.mtekchallenge.data.model.PharmacyModel
import com.yetkin.mtekchallenge.repository.PharmacyRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class PharmacyViewModel(private val pharmacyRepository: PharmacyRepository) : ViewModel() {


    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->
            Log.e("Exception New : ", throwable.message)
        }

    fun getPharmacy(city: String, district: String): MutableLiveData<List<PharmacyModel>> {

        val pharmacy = MutableLiveData<List<PharmacyModel>>()

        viewModelScope.launch(coroutineExceptionHandler) {

            pharmacy.value = pharmacyRepository.getPharmacy(city, district).value
        }

        return pharmacy
    }
}