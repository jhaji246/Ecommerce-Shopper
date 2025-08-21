package com.avi.domain.usecase

import com.avi.domain.repository.OrderRepository

class OrderListUseCase(private val orderRepository: OrderRepository) {
    suspend fun execute(userId: Long) = orderRepository.getOrderList(userId)
}