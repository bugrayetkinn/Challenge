package com.yetkin.mtekchallenge.module

import com.yetkin.mtekchallenge.viewmodel.PharmacyViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */

val pharmacyViewModelModule = module {
    viewModel { PharmacyViewModel(get()) }
}