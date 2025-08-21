package com.avi.domain.usecase

import com.avi.domain.repository.UserRepository

class RegisterUseCase(private val userRepository: UserRepository) {
    suspend fun execute(email: String, password: String, name: String) = userRepository.register(email, password, name)
}