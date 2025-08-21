package com.avi.data.repository

import com.avi.domain.model.AddressDomainModel
import com.avi.domain.model.OrdersListModel
import com.avi.domain.network.NetworkService
import com.avi.domain.network.ResultWrapper
import com.avi.domain.repository.OrderRepository

class OrderRepositoryImpl(private val networkService: NetworkService) : OrderRepository {
    override suspend fun placeOrder(
        addressDomainModel: AddressDomainModel,
        userId: Long
    ): ResultWrapper<Long> {
        return networkService.placeOrder(addressDomainModel, userId)
    }

    override suspend fun getOrderList(userId: Long): ResultWrapper<OrdersListModel> {
        return networkService.getOrderList(userId)
    }
}