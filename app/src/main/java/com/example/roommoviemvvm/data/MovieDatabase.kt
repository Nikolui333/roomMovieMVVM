package com.example.roommoviemvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roommoviemvvm.models.CategoryModel
import com.example.roommoviemvvm.models.FilmsModel


@Database(entities = [CategoryModel::class, FilmsModel::class],version = 1)
abstract class MovieDatabase: RoomDatabase() {

    abstract val filmsDAO : FilmsDao
    abstract val categoryDAO : CategoryDao

    companion object{
        @Volatile
        private var INSTANCE : MovieDatabase? = null
        fun getInstance(context: Context):MovieDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MovieDatabase::class.java,
                        "database"
                    ).build()
                }
                return instance
            }
        }

    }
}