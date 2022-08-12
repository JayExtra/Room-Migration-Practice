package com.dev.appslabke.mytasksapp.repositorty

import android.util.Log
import com.dev.appslabke.mytasksapp.room.dao.DogsDao
import com.dev.appslabke.mytasksapp.room.entity.Dogs
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class DogsRepository @Inject constructor(
    private val dogsDao: DogsDao
) {
    private val TAG = "DogsRepository"

    //GET LIST OF DOGS
    fun getListOfDogs() : Flow<List<Dogs>> = flow {
        emit(dogsDao.getDogs())
    }

    suspend fun addDog(dogsList : List<Dogs>) {
        withContext(Dispatchers.IO){
            try {
                dogsDao.addDogs(dogsList)
            }catch (e : IOException){
                Log.d(TAG, "addDog error : ${e.localizedMessage}")
            }
        }
    }

    suspend fun updateDetails(dog: Dogs){
        withContext(Dispatchers.IO){
            try {
                dogsDao.updateDog(dog)
            }catch (e : IOException){
                Log.d(TAG, "update Dog error : ${e.localizedMessage}")
            }
        }
    }

    suspend fun delete(dog: Dogs) {
        withContext(Dispatchers.IO){
            try {
                dogsDao.deleteDog(dog)
            }catch (e : IOException){
                Log.d(TAG, "delete error : ${e.localizedMessage}")
            }
        }
    }

}