package com.avi.shopper

import android.app.Application
import com.avi.data.di.dataModule
import com.avi.domain.di.domainModule
import com.avi.shopper.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShopperApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ShopperApp)
            modules(listOf(
                presentationModule,
                dataModule,
                domainModule
            ))
        }
    }
}