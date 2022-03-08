package com.example.roommoviemvvm.domain.repository

import androidx.lifecycle.LiveData
import com.example.roommoviemvvm.data.models.FilmsModel

interface FilmsCall {
    fun loadProducts(): LiveData<List<FilmsModel>>

    fun getFilter (nameCategory:String, durationFilm:String):
            LiveData<List<FilmsModel>>

    suspend fun insertFilm(films: FilmsModel)

    suspend fun updateFilm(films: FilmsModel)

    suspend fun deleteFilm(films: FilmsModel)

    suspend fun deleteAllFilms()
}