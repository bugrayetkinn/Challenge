package com.yetkin.mtekchallenge

import android.app.Application
import com.yetkin.mtekchallenge.module.*
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
                newsRetrofitModule, newsRepositoryModule, newsViewModelModule,
                pharmacyViewModelModule, pharmacyRetrofitModule, pharmacyRepositoryModule
            )
        }
    }
}