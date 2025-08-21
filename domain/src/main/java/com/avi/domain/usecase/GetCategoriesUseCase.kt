package com.avi.domain.usecase

import com.avi.domain.repository.CategoryRepository

class GetCategoriesUseCase(private val categoryRepository: CategoryRepository) {
    suspend fun execute() = categoryRepository.getCategories()
}