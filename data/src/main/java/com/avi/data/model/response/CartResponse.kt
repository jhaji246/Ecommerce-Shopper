package com.avi.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class CartResponse(
    val data: List<CartItem>,
    val msg: String
) {
    fun toCartModel(): com.avi.domain.model.CartModel {
return com.avi.domain.model.CartModel(
            data = data.map { it.toCartItemModel() },
            msg = msg
        )
    }
}