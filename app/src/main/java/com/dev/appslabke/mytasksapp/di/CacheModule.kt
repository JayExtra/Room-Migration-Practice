package com.dev.appslabke.mytasksapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
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

   /* val MIGRATION_3_4 = object : Migration(3 , 4) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                "ALTER TABLE dogs_table ADD COLUMN dog_gender STRING"
            )
        }
    }*/

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