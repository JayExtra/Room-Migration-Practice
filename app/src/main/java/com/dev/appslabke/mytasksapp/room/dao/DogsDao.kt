package com.dev.appslabke.mytasksapp.room.dao

import androidx.room.*
import com.dev.appslabke.mytasksapp.room.entity.Dogs

@Dao
interface DogsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDogs(dog : List<Dogs>)

    @Query("SELECT * FROM dogs_table")
    suspend fun getDogs() : List<Dogs>

    @Update
    suspend fun updateDog(dog : Dogs)

    @Delete
    suspend fun deleteDog(dog : Dogs)


}