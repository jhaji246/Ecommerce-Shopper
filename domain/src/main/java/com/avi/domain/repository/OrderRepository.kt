package com.avi.domain.repository

import com.avi.domain.model.AddressDomainModel
import com.avi.domain.model.OrdersListModel
import com.avi.domain.network.ResultWrapper

interface OrderRepository {
    suspend fun placeOrder(addressDomainModel: AddressDomainModel, userId: Long): ResultWrapper<Long>
    suspend fun getOrderList(userId: Long): ResultWrapper<OrdersListModel>
}