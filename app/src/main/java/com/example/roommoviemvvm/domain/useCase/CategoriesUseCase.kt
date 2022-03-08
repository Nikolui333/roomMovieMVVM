package com.example.roommoviemvvm.domain.useCase

import androidx.lifecycle.LiveData
import com.example.roommoviemvvm.data.models.CategoryModel
import com.example.roommoviemvvm.domain.repository.CategoriesCall

class CategoriesUseCase (private val categoriesCall: CategoriesCall) {


    fun loadCategories(): LiveData<List<CategoryModel>> {

        return categoriesCall.loadCategories()

    }

    suspend fun insertCategory(categories: CategoryModel){
        categoriesCall.insertCategory(categories)
    }

    suspend fun updateCategory(categories: CategoryModel){
        categoriesCall.updateCategory(categories)
    }

    suspend fun deleteCategory(categories: CategoryModel) {
        categoriesCall.deleteCategory(categories)
    }

    suspend fun deleteAllCategories(){
        categoriesCall.deleteAllCategories()
    }

}