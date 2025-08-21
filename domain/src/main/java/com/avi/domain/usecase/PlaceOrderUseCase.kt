package com.avi.domain.usecase

import com.avi.domain.model.AddressDomainModel
import com.avi.domain.repository.OrderRepository

class PlaceOrderUseCase(private val orderRepository: OrderRepository) {
    suspend fun execute(address: AddressDomainModel, userId: Long) = orderRepository.placeOrder(address, userId)
}