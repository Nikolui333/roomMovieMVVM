package com.example.roommoviemvvm.presentation.di

import androidx.room.Room
import com.example.roommoviemvvm.data.db.MovieDatabase
import com.example.roommoviemvvm.data.repositories.CategoryRepository
import com.example.roommoviemvvm.data.repositories.FilmsRepository
import com.example.roommoviemvvm.domain.repository.CategoriesCall
import com.example.roommoviemvvm.domain.repository.FilmsCall
import com.example.roommoviemvvm.domain.useCase.CategoriesUseCase
import com.example.roommoviemvvm.domain.useCase.FilmsUseCase
import com.example.roommoviemvvm.viewModels.CategoryViewModel
import com.example.roommoviemvvm.viewModels.FilmsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleCategories = module{

    single {
        Room.databaseBuilder(androidContext(), MovieDatabase::class.java,
            "categoriesLocalDB").build()
    }

    single { get<MovieDatabase>().categoryDAO }

    single<CategoriesCall> { CategoryRepository(get()) }

    single { CategoriesUseCase(get()) }

    viewModel { CategoryViewModel(get()) }

}

val moduleProducts = module{

    single {
        Room.databaseBuilder(androidContext(), MovieDatabase::class.java,
            "filmsLocalDB").build()
    }

    single { get<MovieDatabase>().filmsDAO }

    single<FilmsCall> { FilmsRepository(get()) }

    single { FilmsUseCase(get()) }

    viewModel { FilmsViewModel(get()) }

}


val moduleDBFilms = module{

    single {
        Room.databaseBuilder(androidContext(), MovieDatabase::class.java,
            "dbProducts").build()
    }

    single { get<MovieDatabase>().filmsDAO }

}


val moduleDBCategories = module{

    single {
        Room.databaseBuilder(androidContext(), MovieDatabase::class.java,
            "dbCategories").build()
    }

    single { get<MovieDatabase>().categoryDAO }

}



val moduleCateg = module{

    moduleDBCategories

    single<CategoriesCall> { CategoryRepository(get()) }

    single { CategoriesUseCase(get()) }

    viewModel { CategoryViewModel(get()) }

}

val moduleFilm = module{

    moduleDBFilms

    single<FilmsCall> { FilmsRepository(get()) }

    single { FilmsUseCase(get()) }

    viewModel { FilmsViewModel(get()) }

}