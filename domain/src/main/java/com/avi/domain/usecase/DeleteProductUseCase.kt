package com.avi.domain.usecase

import com.avi.domain.model.CartItemModel
import com.avi.domain.repository.CartRepository

class DeleteProductUseCase(private val cartRepository: CartRepository) {
    suspend fun execute(cartItemId: Int, userId: Long) = cartRepository.deleteItem(cartItemId, userId)
}