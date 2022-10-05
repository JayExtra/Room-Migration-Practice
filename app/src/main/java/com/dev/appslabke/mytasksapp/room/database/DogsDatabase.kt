package com.dev.appslabke.mytasksapp.room.database

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec
import com.dev.appslabke.mytasksapp.room.dao.DogsDao
import com.dev.appslabke.mytasksapp.room.entity.Dogs

@Database(
    version = 4,
    entities = [Dogs::class],
    exportSchema = true ,
    autoMigrations = [
        AutoMigration(
            from = 3 ,
            to = 4,
            spec = DogsDatabase.TestAutoMigration::class
        )
    ]

)
abstract class DogsDatabase : RoomDatabase() {
    abstract fun getDao() : DogsDao

    @RenameColumn(tableName = "dogs_table", fromColumnName = "color" , toColumnName = "dogs_color")
    class TestAutoMigration : AutoMigrationSpec
}



