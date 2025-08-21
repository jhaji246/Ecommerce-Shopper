package com.avi.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class OrdersListResponse(
    val `data`: List<OrderListData>,
    val msg: String
) {
    fun toDomainResponse(): com.avi.domain.model.OrdersListModel {
return com.avi.domain.model.OrdersListModel(
            `data` = `data`.map { it.toDomainResponse() },
            msg = msg
        )
    }
}