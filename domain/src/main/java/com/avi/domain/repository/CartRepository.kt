package com.avi.domain.repository

import com.avi.domain.model.CartItemModel
import com.avi.domain.model.CartModel
import com.avi.domain.model.CartSummary
import com.avi.domain.model.request.AddCartRequestModel
import com.avi.domain.network.ResultWrapper

interface CartRepository {
    suspend fun addProductToCart(
        request: AddCartRequestModel, userId: Long
    ): ResultWrapper<CartModel>

    suspend fun getCart(userId: Long): ResultWrapper<CartModel>
    suspend fun updateQuantity(cartItemModel: CartItemModel, userId: Long): ResultWrapper<CartModel>
    suspend fun deleteItem(cartItemId: Int, userId: Long): ResultWrapper<CartModel>
    suspend fun getCartSummary(userId: Long): ResultWrapper<CartSummary>
}