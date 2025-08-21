package com.avi.domain.usecase

import com.avi.domain.model.CartItemModel
import com.avi.domain.repository.CartRepository

class UpdateQuantityUseCase(private val cartRepository: CartRepository) {
    suspend fun execute(cartItemModel: CartItemModel, userId: Long) = cartRepository.updateQuantity(cartItemModel, userId)
}