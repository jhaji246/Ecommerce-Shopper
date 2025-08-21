package com.avi.domain.di

import com.avi.domain.usecase.AddToCartUseCase
import com.avi.domain.usecase.CartSummaryUseCase
import com.avi.domain.usecase.DeleteProductUseCase
import com.avi.domain.usecase.GetCartUseCase
import com.avi.domain.usecase.GetCategoriesUseCase
import com.avi.domain.usecase.GetProductUseCase
import com.avi.domain.usecase.LoginUseCase
import com.avi.domain.usecase.OrderListUseCase
import com.avi.domain.usecase.PlaceOrderUseCase
import com.avi.domain.usecase.RegisterUseCase
import com.avi.domain.usecase.UpdateQuantityUseCase
import org.koin.dsl.module


val useCaseModule = module {
    factory { GetProductUseCase(get()) }
    factory { GetCategoriesUseCase(get()) }
    factory { AddToCartUseCase(get()) }
    factory { GetCartUseCase(get()) }
    factory { UpdateQuantityUseCase(get()) }
    factory { DeleteProductUseCase(get()) }
    factory { CartSummaryUseCase(get()) }
    factory { PlaceOrderUseCase(get()) }
    factory { OrderListUseCase(get()) }
    factory { LoginUseCase(get()) }
    factory { RegisterUseCase(get()) }
}