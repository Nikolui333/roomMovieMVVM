package com.example.roommoviemvvm.domain.useCase

import androidx.lifecycle.LiveData
import com.example.roommoviemvvm.data.models.FilmsModel
import com.example.roommoviemvvm.domain.repository.FilmsCall

class FilmsUseCase (private val filmsCall: FilmsCall) {


    fun loadFilms(): LiveData<List<FilmsModel>> {

        return filmsCall.loadFilms()

    }

    fun getFilter (nameCategory:String, durationFilm:String):
            LiveData<List<FilmsModel>> {

        return filmsCall.getFilter(nameCategory, durationFilm)

    }

    suspend fun insertFilm(films: FilmsModel){
        filmsCall.insertFilm(films)
    }

    suspend fun updateFilm(films: FilmsModel){
        filmsCall.updateFilm(films)
    }

    suspend fun deleteFilm(films: FilmsModel) {
        filmsCall.deleteFilm(films)
    }

    suspend fun deleteAllFilms(){
        filmsCall.deleteAllFilms()
    }
}