package com.dev.appslabke.mytasksapp.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dogs_table")
data class Dogs(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val dogId : Int,
    @ColumnInfo(name = "name")
    val dogName : String,
    @ColumnInfo(name = "breed")
    val dogBreed : String,
    @ColumnInfo(name="age")
    val dogAge : Int,
    @ColumnInfo(name = "color")
    val dogsColor : String,
    @ColumnInfo(name = "vaccine_status" , defaultValue = "false")
    val vaccinated : Boolean = false
)