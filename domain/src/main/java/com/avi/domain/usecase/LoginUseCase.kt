package com.avi.domain.usecase

import com.avi.domain.repository.UserRepository

class LoginUseCase(private val userRepository: UserRepository) {
    suspend fun execute(email: String, password: String) = userRepository.login(email, password)
}