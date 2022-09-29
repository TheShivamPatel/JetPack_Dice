package com.example.session1

import android.graphics.Color
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.session1.ui.theme.Session1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Session1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceRoll()
                }
            }
        }
    }
}


// App logic in this DiceRoll Composable function ! ! !
@Composable
fun DiceRoll() {

    // result is a variable integer value which is mutable ! ! !
    var result by remember {
        mutableStateOf(1)
    }

    // ImageResource is a variable which pass image in ImageView according to result ! ! !
    var ImageResource = when(result){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    // we using COLUMN  for placing views in Vertical Orientation ! ! !
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        //Image of Dice face according to result ! ! !
        Image(painter = painterResource(ImageResource), contentDescription = "image")

        // Spacer is use for giving space between the Views ! ! !
        Spacer(modifier = Modifier.height(100.dp))

        // Generating random number by Button ! ! !
        Button(onClick = { result = (1..6).random() } , modifier = Modifier.height(80.dp).width(110.dp) ) {
            Text(text = "Roll" , fontSize = 30.sp)
        }

    }
}


// getting preview of app! ! !
@Preview
@Composable
fun DiceRollerAppPreview() {
    DiceRoll()
}

//  dice images =>" https://drive.google.com/drive/folders/18cnBIvDH3IrnqUkx636u0y2JP1qDQYfe?usp=sharing "//
