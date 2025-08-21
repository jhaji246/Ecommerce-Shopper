package com.avi.data.repository

import com.avi.data.model.CategoryDataModel
import com.avi.domain.model.CategoriesListModel
import com.avi.domain.network.NetworkService
import com.avi.domain.network.ResultWrapper
import com.avi.domain.repository.CategoryRepository

class CategoryRepositoryImpl(val networkService: NetworkService) : CategoryRepository {
    override suspend fun getCategories(): ResultWrapper<CategoriesListModel> {
        return networkService.getCategories()
    }
}