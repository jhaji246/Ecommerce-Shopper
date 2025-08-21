package com.avi.domain.usecase

import com.avi.domain.repository.CartRepository

class CartSummaryUseCase (private val repository: CartRepository) {
    suspend fun execute(userId: Long) = repository.getCartSummary(userId)
}