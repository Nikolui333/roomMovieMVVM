package com.example.roommoviemvvm.presentation

import android.app.Application
import com.example.roommoviemvvm.presentation.di.moduleCateg
import com.example.roommoviemvvm.presentation.di.moduleDBCategories
import com.example.roommoviemvvm.presentation.di.moduleDBFilms
import com.example.roommoviemvvm.presentation.di.moduleFilm
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@App)

            modules(moduleDBCategories, moduleDBFilms, moduleCateg, moduleFilm)

        }

    }
}