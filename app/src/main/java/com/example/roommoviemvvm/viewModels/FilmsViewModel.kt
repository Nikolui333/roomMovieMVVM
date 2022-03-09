package com.example.roommoviemvvm.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roommoviemvvm.data.models.FilmsModel
import com.example.roommoviemvvm.data.repositories.FilmsRepository
import com.example.roommoviemvvm.domain.useCase.FilmsUseCase

import kotlinx.coroutines.launch

class FilmsViewModel (private val filmUseCase: FilmsUseCase) : ViewModel() {

    val films = filmUseCase.loadFilms()

    fun getFilter (nameCategory:String, durationFilm:String):
            LiveData<List<FilmsModel>> {
        return filmUseCase.getFilter(nameCategory, durationFilm)
    }

    fun startInsert(nameFilm:String, categoryFilm:String, durationFilm:String) {
        insertFilm(FilmsModel(0,nameFilm, categoryFilm, durationFilm))
    }

    fun startUpdateFilm(idProduct:Int, nameFilm:String, nameCategory:String, durationFilm:String) {
        updateFilm(FilmsModel(idProduct, nameFilm, nameCategory, durationFilm))
    }

    fun insertFilm(filmsModel: FilmsModel) = viewModelScope.launch{

        filmUseCase.insertFilm(filmsModel)
    }

    fun updateFilm(filmsModel: FilmsModel) = viewModelScope.launch{

        filmUseCase.updateFilm(filmsModel)
    }

    fun deleteFilm(filmsModel: FilmsModel) = viewModelScope.launch{

        filmUseCase.deleteFilm(filmsModel)
    }

    fun deleteAllFilms() = viewModelScope.launch{

        filmUseCase.deleteAllFilms()
    }
}