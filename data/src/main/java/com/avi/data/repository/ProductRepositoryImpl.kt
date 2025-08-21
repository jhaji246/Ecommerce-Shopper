package com.avi.data.repository

import com.avi.domain.model.Product
import com.avi.domain.model.ProductListModel
import com.avi.domain.network.NetworkService
import com.avi.domain.network.ResultWrapper
import com.avi.domain.repository.ProductRepository

class ProductRepositoryImpl(private val networkService: NetworkService) : ProductRepository {
    override suspend fun getProducts(category: Int?): ResultWrapper<ProductListModel> {
        return networkService.getProducts(category)
    }
}