package com.example.newlearnverse

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp


@Composable
// passthrough subjectName:String
fun subjectScreen(subjectName: String) {

    Card (modifier = Modifier
        .fillMaxWidth()
        .size(90.dp)
        .padding(top = 6.dp)
        .height(height = 30.dp),
        shape = CutCornerShape(topEnd = 20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Blue),
    ){
        Box(modifier = Modifier.fillMaxSize()) {
            /*
            *  Image(
            *       painter = painterResource(id = R.drawable.<image>),
            *       contentDescription = null,
            *       contentScale = ContentScale.Crop,
            *       modifier = Modifier.matchParentsSize()
            * )
            * */

                Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    //Text(text = subjectName)

                    Spacer(modifier = Modifier.size(size = 16.dp))



                }
        }
    }

}