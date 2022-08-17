package com.dev.appslabke.mytasksapp.viewmodel

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
                dogBreed = "German Lackie" ,
                dogsColor = "Brown" ,
                vaccinated = true
            ) ,
            Dogs(
                dogId = 2,
                dogName = "Nkoko",
                dogAge = 5,
                dogBreed = "German Shephered",
                dogsColor = "White",
                vaccinated = true
            ),
            Dogs(
                dogId = 3,
                dogName = "Kimonji",
                dogAge = 3 ,
                dogBreed = "Shitzu",
                dogsColor = "White and Black",
                vaccinated = true
            ),
            Dogs(
                dogId = 4,
                dogName = "Boss",
                dogAge = 1 ,
                dogBreed = "Cockal Spaniol",
                dogsColor = "White and Grey",
                vaccinated = true
            ),
            Dogs(
                dogId = 5,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "White",
                vaccinated = true
            ),
            Dogs(
                dogId = 6,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "Brown and Black",
                vaccinated = true
            ),
            Dogs(
                dogId = 7,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "Black",
                vaccinated = true
            ),
            Dogs(
                dogId = 8,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "Grey",
                vaccinated = true
            ),
            Dogs(
                dogId = 9,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "White ",
                vaccinated = true
            ),
            Dogs(
                dogId = 10,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "White and Black",
                vaccinated = true
            ),
            Dogs(
                dogId = 11,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "White and Grey",
                vaccinated = true
            ),
            Dogs(
                dogId = 12,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "Ginger",
                vaccinated = true
            ),
            Dogs(
                dogId = 13,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "White and Ginger",
                vaccinated = true
            ),
            Dogs(
                dogId = 14,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "White and Black",
                vaccinated = true
            ),
            Dogs(
                dogId = 15,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "White",
                vaccinated = true
            ),
            Dogs(
                dogId = 16,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "White and Black",
                vaccinated = true
            ),
            Dogs(
                dogId = 17,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "Black",
                vaccinated = true
            ),
            Dogs(
                dogId = 18,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "Brown",
                vaccinated = true
            ),
            Dogs(
                dogId = 19,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "Black",
                vaccinated = true
            ),
            Dogs(
                dogId = 20,
                dogName = "Kioko",
                dogAge = 6 ,
                dogBreed = "Malamut",
                dogsColor = "Ginger",
                vaccinated = true
            )

        )

        repository.addDog(dogsList)
    }
}