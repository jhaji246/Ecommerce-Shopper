package com.avi.domain.repository

import com.avi.domain.model.UserDomainModel
import com.avi.domain.network.ResultWrapper

interface UserRepository {
    suspend fun login(email: String, password: String): ResultWrapper<UserDomainModel>
    suspend fun register(
        email: String,
        password: String,
        name: String
    ): ResultWrapper<UserDomainModel>
}