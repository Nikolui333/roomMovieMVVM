package com.example.roommoviemvvm.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roommoviemvvm.domain.useCase.CategoriesUseCase

class CategoryFactory (private val categoryRepository: CategoriesUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CategoryViewModel::class.java)){
            return CategoryViewModel(categoryRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}