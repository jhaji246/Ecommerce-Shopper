package com.avi.shopper.navigation

import android.annotation.SuppressLint
import android.os.Parcelable
import com.avi.shopper.model.UserAddress
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
@Parcelize
data class UserAddressRouteWrapper(
    val userAddress: UserAddress?
) : Parcelable
