package com.avi.domain.repository

import com.avi.domain.model.Product
import com.avi.domain.model.ProductListModel
import com.avi.domain.network.ResultWrapper

interface ProductRepository {
    suspend fun getProducts(category:Int?): ResultWrapper<ProductListModel>
}