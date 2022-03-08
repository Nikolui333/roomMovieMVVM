package com.example.roommoviemvvm.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films_data_table")
data class FilmsModel (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "films_id")
    var id : Int,

    @ColumnInfo(name = "films_name")
    var name : String,

    @ColumnInfo(name = "films_category")
    var category : String,

    @ColumnInfo(name = "films_duration")
    var duration : String

)