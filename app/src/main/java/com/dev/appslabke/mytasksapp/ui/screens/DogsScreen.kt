package com.dev.appslabke.mytasksapp.ui.screens

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import com.dev.appslabke.mytasksapp.R
import com.dev.appslabke.mytasksapp.room.entity.Dogs
import com.dev.appslabke.mytasksapp.viewmodel.DogsScreenViewModel

@Composable
fun DogsScreen(
    dogsViewModel : DogsScreenViewModel = hiltViewModel()
){
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val dogsListFlowLifecycleAware = remember(dogsViewModel.dogsListStateFlow , lifecycleOwner) {
        dogsViewModel.dogsListStateFlow.flowWithLifecycle(lifecycleOwner.lifecycle , Lifecycle.State.STARTED)
    }
    
    val dogsList : List<Dogs> by dogsListFlowLifecycleAware.collectAsState(initial = emptyList())

    Column(
        horizontalAlignment = Alignment.CenterHorizontally ,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 8.dp , horizontal = 8.dp)
        ) {
            Text(
                text = "My Pet Store",
                fontWeight = FontWeight.Bold ,
                fontSize = 18.sp,
                textAlign = TextAlign.Start
            )
        }



        if(dogsList.isEmpty()){
            Text(
                text = "no dogs registered in the database"
            )
        }else {

            LazyColumn(contentPadding = PaddingValues(8.dp)){
                items(dogsList.size){ itemPos ->
                    DogDetailsCardComponent(
                        onClick = {
                            //navigate to dog screen
                                  Toast.makeText(
                                      context ,
                                      "You have selected ${dogsList[itemPos]}" ,
                                      Toast.LENGTH_SHORT
                                  ).show()
                        },
                        deleteDog = {
                            //delete dog
                             dogsViewModel.deleteDog(it)
                        },

                        dog = dogsList[itemPos]
                       // modifier = Modifier.padding(top = 8.dp)
                    )

                }

            }

        }



    }



}

@Composable
fun DogDetailsCardComponent(
    onClick : (Dogs) -> Unit ,
    deleteDog : (Dogs) -> Unit ,
    dog: Dogs,
    modifier: Modifier = Modifier
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick.invoke(dog)
            }
            .padding(top = 8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 2.dp,
        backgroundColor = Color.White

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically ,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {

            Box(
                contentAlignment = Alignment.Center ,
                modifier = Modifier
                    .height(70.dp)
                    .width(70.dp)
                    .clip(shape = CircleShape)
                    .background(Color.Gray)
                    .padding(16.dp)
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = R.drawable.ic_round_pets),
                    contentDescription = stringResource(R.string.pet_logo)
                )

            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = dog.dogName ,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = dog.dogBreed ,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )

                Text(
                    text = dog.dogAge.toString() ,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )

            }

            IconButton(
                onClick = {
                    deleteDog.invoke(dog)
                } ,
                modifier = Modifier
                    .height(50.dp)
                    .width(50.dp)
                    .clip(CircleShape)
                    .background(Color.Gray)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_round_delete ),
                    contentDescription = stringResource(R.string.delete_text)
                )
            }

        }

    }

}



