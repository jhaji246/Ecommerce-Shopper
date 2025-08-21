package com.avi.domain.usecase

import com.avi.domain.model.request.AddCartRequestModel
import com.avi.domain.repository.CartRepository

class AddToCartUseCase(private val cartRepository: CartRepository) {
    suspend fun execute(request: AddCartRequestModel, userId: Long) = cartRepository.addProductToCart(request,userId)
}