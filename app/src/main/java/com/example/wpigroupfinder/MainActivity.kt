package com.example.wpigroupfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.wpigroupfinder.screens.clubowner.ClubEventsScreenDesign
import com.example.wpigroupfinder.screens.clubowner.ClubOwnerScreenDesign
import com.example.wpigroupfinder.screens.clubowner.EditClubPageScreenDesign
import com.example.wpigroupfinder.screens.clubowner.EditEventScreenDesign
import com.example.wpigroupfinder.screens.mainview.EventFeedScreenDesign
import com.example.wpigroupfinder.screens.login.LoginScreenDesign
import com.example.wpigroupfinder.screens.mainview.MapScreenDesign
import com.example.wpigroupfinder.screens.login.RegisterScreenDesign
import com.example.wpigroupfinder.screens.login.UserScreenDesign
import com.example.wpigroupfinder.screens.mainview.VerificationScreenDesign
import com.example.wpigroupfinder.screens.mainview.ViewClubPageScreenDesign
import com.example.wpigroupfinder.screens.mainview.ViewEventScreenDesign
import com.example.wpigroupfinder.ui.theme.WPIGroupFinderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WPIGroupFinderTheme {
                MyApp()
            }
        }
    }

    @Composable
    fun MyApp() {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "eventFeed"
        ) {
            //login
            composable("login") { LoginScreenDesign(navController) }
            composable("register") { RegisterScreenDesign(navController) }
            composable("user") { UserScreenDesign(navController) }

            //clubOwner
            composable("clubOwner") { ClubOwnerScreenDesign(navController) }
            composable("clubEvents") { ClubEventsScreenDesign(navController) }
            composable("editClubPage") { EditClubPageScreenDesign(navController) }
            composable("editEvent") { EditEventScreenDesign(navController) }

            //all visible
            composable("eventFeed") { EventFeedScreenDesign(navController) }
            composable("map") { MapScreenDesign(navController) }
            composable(
                route = "viewEvent/{eventId}",
                arguments = listOf(navArgument("eventId") { type = NavType.IntType })
            ) { backStackEntry ->
                val eventId = backStackEntry.arguments?.getInt("eventId")
                ViewEventScreenDesign(navController, eventId)
            }
            composable("viewClubPage") { ViewClubPageScreenDesign(navController) } //will need extra args
            composable("verification") { VerificationScreenDesign(navController) } //will need extra args
            composable("home") { HomeScreenDesign(navController) }
            composable("details") { DetailsScreenDesign(navController) }
            composable("createUser") {CreateUserScreen(navController)}
            composable("viewUser") { UserProfile(navController) }
        }
    }
}


