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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Book
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newlearnverse.components.TopBar
import kotlinx.coroutines.launch


@Composable
fun SubjectScreenWTopBar() {

    Scaffold { paddingValues ->
        Screen(modifier = Modifier.padding(paddingValues))
        //subjectScreen("MAth", modifier = Modifier.padding(paddingValues))
        }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen(modifier: Modifier = Modifier) {

    // For Navigation Drawer
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scope = rememberCoroutineScope()

    // For Top Bar
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet() {
                DrawerContent()
            }
        }
    ) {
        Scaffold (
            topBar = {
                TopBar(
                    onOpenDrawer = {
                    scope.launch{
                        drawerState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                    },
                    scrollBehavior = scrollBehavior
                    )
            },
            modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
        ) { paddingValues ->
            ScreenContent(paddingValues)
        }
    } // End of ModalNavigationDrawer

} // end of Screen()

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
            // Put the subject cards here
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
fun DrawerContent(modifier: Modifier = Modifier) {
    Text(text = "App Name",
        fontSize = 17.sp,
        modifier = Modifier.padding(16.dp))

    HorizontalDivider()

    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Rounded.Book,
                contentDescription = "Subject 1"
            )
        },
        label = {
            Text(text = "Subject 1",
                fontSize = 17.sp,
                modifier = Modifier.padding(16.dp))
        },
        selected = false,
        onClick = {  }
    )

    Spacer(modifier = Modifier.height( 8.dp ))

    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Rounded.Book,
                contentDescription = "Subject 2"
            )
        },
        label = {
            Text(text = "Subject 2",
                fontSize = 17.sp,
                modifier = Modifier.padding(16.dp))
        },
        selected = false,
        onClick = {  }
    )

    Spacer(modifier = Modifier.height( 8.dp ))

    NavigationDrawerItem(
        icon = {
            Icon(
                imageVector = Icons.Rounded.Book,
                contentDescription = "Subject 3"
            )
        },
        label = {
            Text(text = "Subject 3",
                fontSize = 17.sp,
                modifier = Modifier.padding(16.dp))
        },
        selected = false,
        onClick = {  }
    )



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