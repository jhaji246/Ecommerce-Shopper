package com.avi.data.di

import com.avi.data.repository.CategoryRepositoryImpl
import com.avi.data.repository.ProductRepositoryImpl
import com.avi.domain.repository.CartRepository
import com.avi.domain.repository.CategoryRepository
import com.avi.domain.repository.OrderRepository
import com.avi.domain.repository.ProductRepository
import com.avi.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ProductRepository> { ProductRepositoryImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
    single<CartRepository> { com.avi.data.repository.CartRepositoryImpl(get()) }
    single<OrderRepository> { com.avi.data.repository.OrderRepositoryImpl(get()) }
    single<UserRepository> { com.avi.data.repository.UserRepositoryImpl(get()) }
}