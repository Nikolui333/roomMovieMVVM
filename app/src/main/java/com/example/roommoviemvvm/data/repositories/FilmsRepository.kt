package com.example.roommoviemvvm.data.repositories

import androidx.lifecycle.LiveData

import com.example.roommoviemvvm.data.db.FilmsDao
import com.example.roommoviemvvm.data.models.FilmsModel
import com.example.roommoviemvvm.domain.repository.FilmsCall

class FilmsRepository (private val filmDAO: FilmsDao) : FilmsCall {

    override fun loadProducts(): LiveData<List<FilmsModel>> {
        return filmDAO.getAllFilms()
    }

    override fun getFilter (nameCategory:String, durationFilm:String):
            LiveData<List<FilmsModel>> {
        return filmDAO.getFilter(nameCategory, durationFilm)
    }

    override suspend fun insertFilm(filmsModel: FilmsModel){
        filmDAO.insertFilm(filmsModel)
    }

    override suspend fun updateFilm(filmsModel: FilmsModel){
        filmDAO.updateFilm(filmsModel)
    }

    override suspend fun deleteFilm(filmsModel: FilmsModel) {
        filmDAO.deleteFilm(filmsModel)
    }

    override suspend fun deleteAllFilms(){
        filmDAO.deleteAllFilms()
    }
}