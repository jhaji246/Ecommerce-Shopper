package com.avi.shopper.model

import android.os.Parcelable
import com.avi.data.model.request.AddressDataModel
import com.avi.domain.model.AddressDomainModel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class UserAddress(
    val addressLine: String,
    val city: String,
    val state: String,
    val postalCode: String,
    val country: String
) : Parcelable {
    override fun toString(): String {
        return "$addressLine, $city, $state, $postalCode, $country"
    }

    fun toAddressDataModel() = AddressDomainModel(
        addressLine,
        city,
        state,
        postalCode,
        country
    )
}
