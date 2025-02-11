package com.example.newlearnverse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newlearnverse.ui.theme.NewLearnVerseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewLearnVerseTheme {

                val navController = rememberNavController()


                NavHost(navController = navController, startDestination = Routes.loginScreen, builder = {
                    composable(Routes.loginScreen) {
                        LoginScreen(navController)
                    }

                    composable(Routes.homeScreen) {
                        SubjectScreenWTopBar(navController)
                    }

                    composable(Routes.profScreen) {
                        ProfileScreen()
                    }
                })



                //SubjectScreenWTopBar()

            }


        }
    }
}




 







