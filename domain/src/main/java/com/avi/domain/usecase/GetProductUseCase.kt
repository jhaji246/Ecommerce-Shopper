package com.avi.domain.usecase

import com.avi.domain.repository.ProductRepository

class GetProductUseCase(private val productRepository: ProductRepository) {
    suspend fun execute(category: Int?) = productRepository.getProducts(category)
}