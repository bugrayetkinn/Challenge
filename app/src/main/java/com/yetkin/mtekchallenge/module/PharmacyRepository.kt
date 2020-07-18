package com.yetkin.mtekchallenge.module

import com.yetkin.mtekchallenge.repository.PharmacyRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
val pharmacyRepositoryModule = module {
    single { PharmacyRepository(get()) }
}