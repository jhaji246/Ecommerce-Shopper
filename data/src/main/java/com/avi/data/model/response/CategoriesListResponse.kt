package com.avi.data.model.response

import com.avi.data.model.CategoryDataModel
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesListResponse(
    val `data`: List<CategoryDataModel>,
    val msg: String
) {
    fun toCategoriesList() = com.avi.domain.model.CategoriesListModel(
        categories = `data`.map { it.toCategory() },
        msg = msg
    )
}