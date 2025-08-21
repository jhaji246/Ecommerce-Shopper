package com.avi.shopper.di

import com.avi.shopper.ShopperSession
import org.koin.dsl.module

val presentationModule = module {
    includes(viewModelModule)
    single { ShopperSession(get()) }
}