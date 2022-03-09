package com.example.roommoviemvvm.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roommoviemvvm.data.models.CategoryModel
import com.example.roommoviemvvm.data.repositories.CategoryRepository
import com.example.roommoviemvvm.domain.useCase.CategoriesUseCase

import kotlinx.coroutines.launch

class CategoryViewModel (private val categoriesUseCase: CategoriesUseCase) : ViewModel() {

    val categories = categoriesUseCase.loadCategories()

    fun startInsert(nameCategories: String) {
        insert(CategoryModel(0, nameCategories))
    }

    fun startUpdateProduct(idCategories: Int, nameCategories: String) {
        updateProduct(CategoryModel(idCategories, nameCategories))
    }

    fun insert(categoryModel: CategoryModel) = viewModelScope.launch {

        categoriesUseCase.insertCategory(categoryModel)
    }

    fun updateProduct(categoryModel: CategoryModel) = viewModelScope.launch {

        categoriesUseCase.updateCategory(categoryModel)
    }

    fun delete(categoryModel: CategoryModel) = viewModelScope.launch {

        categoriesUseCase.deleteCategory(categoryModel)
    }

    fun deleteAll() = viewModelScope.launch {

        categoriesUseCase.deleteAllCategories()
    }
}