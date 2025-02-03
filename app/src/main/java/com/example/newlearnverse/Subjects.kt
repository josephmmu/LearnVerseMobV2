package com.example.newlearnverse

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.newlearnverse.components.TopBar


@Composable
fun SubjectScreenWTopBar() {

    Scaffold { paddingValues ->
        Screen( modifier = Modifier.padding(paddingValues))
        //subjectScreen("MAth", modifier = Modifier.padding(paddingValues))
        }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(modifier: Modifier = Modifier) {

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )

    Scaffold (
        modifier = modifier
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { TopBar(scrollBehavior = scrollBehavior) }
    ) { paddingValues ->
        ScreenContent(paddingValues)

    }
}

// Only Temporary but these should be the subjects
@Composable
fun ScreenContent(paddingValues: PaddingValues) {
    LazyColumn (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(
            top = paddingValues.calculateTopPadding() + 16.dp
        )
    ){
        items(10) {
            Box(modifier = Modifier
                .padding(horizontal = 10.dp)
                .height(200.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(20.dp))
                .background(MaterialTheme.colorScheme.inversePrimary)) {

            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}



@Composable
// passthrough subjectName:String
fun subjectScreen(subjectName: String, modifier: Modifier) {

    Card (modifier = Modifier
        .fillMaxWidth()
        .size(90.dp)
        .padding(top = 6.dp)
        // change this wrapContentHeight thing to make it show on the screen
        .wrapContentHeight(align = Alignment.Top),
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