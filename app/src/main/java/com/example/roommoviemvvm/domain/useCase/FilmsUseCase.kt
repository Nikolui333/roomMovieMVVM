package com.example.roommoviemvvm.domain.useCase

import androidx.lifecycle.LiveData
import com.example.roommoviemvvm.data.models.FilmsModel
import com.example.roommoviemvvm.domain.repository.FilmsCall

class FilmsUseCase (private val productsCall: FilmsCall) {


    fun loadFilms(): LiveData<List<FilmsModel>> {

        return productsCall.loadProducts()

    }

    fun getFilter (nameCategory:String, priceProduct:String):
            LiveData<List<FilmsModel>> {

        return productsCall.getFilter(nameCategory, priceProduct)

    }

    suspend fun insertFilm(products: FilmsModel){
        productsCall.insertFilm(products)
    }

    suspend fun updateFilm(products: FilmsModel){
        productsCall.updateFilm(products)
    }

    suspend fun deleteFilm(products: FilmsModel) {
        productsCall.deleteFilm(products)
    }

    suspend fun deleteAllFilms(){
        productsCall.deleteAllFilms()
    }
}