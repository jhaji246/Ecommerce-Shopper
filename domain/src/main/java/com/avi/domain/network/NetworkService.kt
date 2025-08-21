package com.avi.domain.network

import com.avi.domain.model.AddressDomainModel
import com.avi.domain.model.CartItemModel
import com.avi.domain.model.CartModel
import com.avi.domain.model.CartSummary
import com.avi.domain.model.CategoriesListModel
import com.avi.domain.model.OrdersListModel
import com.avi.domain.model.ProductListModel
import com.avi.domain.model.UserDomainModel
import com.avi.domain.model.request.AddCartRequestModel

interface NetworkService {
    suspend fun getProducts(category: Int?): ResultWrapper<ProductListModel>
    suspend fun getCategories(): ResultWrapper<CategoriesListModel>

    suspend fun addProductToCart(
        request: AddCartRequestModel,
        userId: Long
    ): ResultWrapper<CartModel>

    suspend fun getCart(userId: Long): ResultWrapper<CartModel>
    suspend fun updateQuantity(cartItemModel: CartItemModel, userId: Long): ResultWrapper<CartModel>
    suspend fun deleteItem(cartItemId: Int, userId: Long): ResultWrapper<CartModel>
    suspend fun getCartSummary(userId: Long): ResultWrapper<CartSummary>
    suspend fun placeOrder(address: AddressDomainModel, userId: Long): ResultWrapper<Long>
    suspend fun getOrderList(userId: Long): ResultWrapper<OrdersListModel>
    suspend fun login(email: String, password: String): ResultWrapper<UserDomainModel>
    suspend fun register(
        email: String,
        password: String,
        name: String
    ): ResultWrapper<UserDomainModel>
}

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class Failure(val exception: Exception) : ResultWrapper<Nothing>()
}