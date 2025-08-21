package com.avi.domain.repository

import com.avi.domain.model.CategoriesListModel
import com.avi.domain.network.ResultWrapper

interface CategoryRepository {
    suspend fun getCategories(): ResultWrapper<CategoriesListModel>
}