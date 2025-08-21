package com.avi.shopper.ui.feature.summary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avi.domain.model.CartSummary
import com.avi.domain.usecase.CartSummaryUseCase
import com.avi.domain.usecase.PlaceOrderUseCase
import com.avi.shopper.ShopperSession
import com.avi.shopper.model.UserAddress
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CartSummaryViewModel(
    private val cartSummaryUseCase: CartSummaryUseCase,
    private val placeOrderUseCase: PlaceOrderUseCase,
    private val shopperSession: ShopperSession
) : ViewModel() {

    private val _uiState = MutableStateFlow<CartSummaryEvent>(CartSummaryEvent.Loading)
    val uiState = _uiState.asStateFlow()
    val userDomainModel = shopperSession.getUser()

    init {
        getCartSummary(userDomainModel!!.id!!.toLong())
    }

    private fun getCartSummary(userId: Long) {
        viewModelScope.launch {
            _uiState.value = CartSummaryEvent.Loading
            val summary = cartSummaryUseCase.execute(userId)
            when (summary) {
                is com.avi.domain.network.ResultWrapper.Success -> {
                    _uiState.value = CartSummaryEvent.Success(summary.value)
                }

                is com.avi.domain.network.ResultWrapper.Failure -> {
                    _uiState.value = CartSummaryEvent.Error("Something went wrong!")
                }
            }
        }
    }

    public fun placeOrder(userAddress: UserAddress) {
        viewModelScope.launch {
            _uiState.value = CartSummaryEvent.Loading
            val orderId = placeOrderUseCase.execute(
                userAddress.toAddressDataModel(),
                userDomainModel!!.id!!.toLong()
            )
            when (orderId) {
                is com.avi.domain.network.ResultWrapper.Success -> {
                    _uiState.value = CartSummaryEvent.PlaceOrder(orderId.value)
                }

                is com.avi.domain.network.ResultWrapper.Failure -> {
                    _uiState.value = CartSummaryEvent.Error("Something went wrong!")
                }
            }
        }
    }
}

sealed class CartSummaryEvent {
    data object Loading : CartSummaryEvent()
    data class Error(val error: String) : CartSummaryEvent()
    data class Success(val summary: CartSummary) : CartSummaryEvent()
    data class PlaceOrder(val orderId: Long) : CartSummaryEvent()
}