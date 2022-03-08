package com.example.roommoviemvvm.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roommoviemvvm.viewModels.FilmsViewModel
import com.example.roommoviemvvm.data.repositories.FilmsRepository

class FilmsFactory (private val productRepository: FilmsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilmsViewModel::class.java)) {
            return FilmsViewModel(productRepository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }

}