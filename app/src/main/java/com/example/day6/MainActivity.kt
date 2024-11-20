package com.example.day6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.day6.ui.theme.Day6Theme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Day6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    CaptainGame()
                }
            }
        }
    }
}

@Composable
fun CaptainGame(){
    val treasureFood = remember {mutableStateOf(0)}
    val direction = remember {   mutableStateOf("North") }
    val stormOrTreasure = remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            horizontalArrangement = Arrangement.Center
        ){
            Text(text = "Treasures Found: ${treasureFood.value}")
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "Current Direction: ${direction.value}")
        }
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                direction.value="East"
                if(Random.nextBoolean()){
                    treasureFood.value+=1
                    stormOrTreasure.value = "Found a Treasure!"
                } else {
                    stormOrTreasure.value = "Storm Ahead!"
                }

            }) {
               Text(text = "Sail East")            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(onClick = {
                direction.value="West"
                if(Random.nextBoolean()){
                    treasureFood.value+=1
                    stormOrTreasure.value = "Found a Treasure!"
                } else {
                    stormOrTreasure.value = "Storm Ahead!"
                }

            }) {
                Text(text = "Sail West")            }


        }


        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                direction.value="North"
                if(Random.nextBoolean()){
                    treasureFood.value+=1
                    stormOrTreasure.value = "Found a Treasure!"
                } else {
                    stormOrTreasure.value = "Storm Ahead!"
                }

            }) {
                Text(text = "Sail North")            }


            Spacer(modifier = Modifier.width(10.dp))

            Button(onClick = {
                direction.value="South"
                if(Random.nextBoolean()){
                    treasureFood.value+=1
                    stormOrTreasure.value = "Found a Treasure!"
                } else {
                    stormOrTreasure.value = "Storm Ahead!"
                }

            }) {
                Text(text = "Sail South")            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = stormOrTreasure.value)


    }

}

