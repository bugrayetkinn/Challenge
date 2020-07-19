package com.yetkin.mtekchallenge

import android.app.Application
import com.yetkin.mtekchallenge.module.pharmacyRepositoryModule
import com.yetkin.mtekchallenge.module.pharmacyRetrofitModule
import com.yetkin.mtekchallenge.module.pharmacyViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


/**

Created by : Buğra Yetkin

Mail : bugrayetkinn@gmail.com

 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                pharmacyViewModelModule, pharmacyRetrofitModule, pharmacyRepositoryModule
            )
        }
    }
}