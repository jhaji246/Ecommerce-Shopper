package com.avi.domain.usecase

import com.avi.domain.repository.CartRepository

class GetCartUseCase(private val cartRepository: CartRepository) {
    suspend fun execute(userId: Long) = cartRepository.getCart(userId)
}