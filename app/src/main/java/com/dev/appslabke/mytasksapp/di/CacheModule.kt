package com.dev.appslabke.mytasksapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dev.appslabke.mytasksapp.room.dao.DogsDao
import com.dev.appslabke.mytasksapp.room.database.DogsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context : Context
    ) : DogsDatabase {
        return Room.databaseBuilder(
            context ,
            DogsDatabase::class.java ,
            "dogs_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDao(
        db : DogsDatabase
    ) : DogsDao = db.getDao()
}