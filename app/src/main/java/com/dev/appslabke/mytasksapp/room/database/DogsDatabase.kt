package com.dev.appslabke.mytasksapp.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dev.appslabke.mytasksapp.room.dao.DogsDao
import com.dev.appslabke.mytasksapp.room.entity.Dogs

@Database(
    version = 1,
    entities = [Dogs::class]
)
abstract class DogsDatabase : RoomDatabase() {
    abstract fun getDao() : DogsDao
}
