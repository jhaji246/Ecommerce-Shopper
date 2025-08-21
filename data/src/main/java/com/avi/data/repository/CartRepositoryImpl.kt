package com.avi.data.repository

import com.avi.domain.model.CartItemModel
import com.avi.domain.model.CartModel
import com.avi.domain.model.CartSummary
import com.avi.domain.model.request.AddCartRequestModel
import com.avi.domain.network.NetworkService
import com.avi.domain.network.ResultWrapper
import com.avi.domain.repository.CartRepository

class CartRepositoryImpl(val networkService: NetworkService) : CartRepository {
    override suspend fun addProductToCart(
        request: AddCartRequestModel,
        userId: Long
    ): ResultWrapper<CartModel> {
        return networkService.addProductToCart(request, userId)
    }

    override suspend fun getCart(userId: Long): ResultWrapper<CartModel> {
        return networkService.getCart(userId)
    }

    override suspend fun updateQuantity(
        cartItemModel: CartItemModel,
        userId: Long
    ): ResultWrapper<CartModel> {
        return networkService.updateQuantity(cartItemModel, userId)
    }

    override suspend fun deleteItem(cartItemId: Int, userId: Long): ResultWrapper<CartModel> {
        return networkService.deleteItem(cartItemId, userId)
    }

    override suspend fun getCartSummary(userId: Long): ResultWrapper<CartSummary> {
        return networkService.getCartSummary(userId)
    }
}