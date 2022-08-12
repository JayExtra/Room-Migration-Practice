package com.dev.appslabke.mytasksapp.viewmodel

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev.appslabke.mytasksapp.repositorty.DogsRepository
import com.dev.appslabke.mytasksapp.room.entity.Dogs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogsScreenViewModel @Inject constructor(
    private val repository: DogsRepository
) : ViewModel() {

    init {
        addDogs()
    }

    val dogsListStateFlow : StateFlow<List<Dogs>> =
        repository.getListOfDogs().stateIn(
            viewModelScope ,
            SharingStarted.Eagerly ,
           initialValue = emptyList()
        )


    fun deleteDog(dog : Dogs) = viewModelScope.launch{
        repository.delete(dog)
    }

    private fun addDogs() = viewModelScope.launch{
        val dogsList = listOf(
            Dogs(
                dogId = 1,
                dogName = "Papa",
                dogAge = 2 ,
                dogBreed = "German Lackie"
            ) ,
            Dogs(
                dogId = 2,
                dogName = "Nkoko",
                dogAge = 5,
                dogBreed = "German Shephered"
            ),
            Dogs(
                dogId = 3,
                dogName = "Kimonji",
                dogAge = 3 ,
                dogBreed = "Shitzu"
            ),
            Dogs(
                dogId = 4,
                dogName = "Boss",
                dogAge = 1 ,
                dogBreed = "Cockal Spaniol"
            ),
            Dogs(
                dogId = 5,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 6,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 7,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 8,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 9,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 10,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 11,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 12,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 13,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 14,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 15,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 16,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 17,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 18,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 19,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            ),
            Dogs(
                dogId = 20,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut"
            )

        )

        repository.addDog(dogsList)
    }
}