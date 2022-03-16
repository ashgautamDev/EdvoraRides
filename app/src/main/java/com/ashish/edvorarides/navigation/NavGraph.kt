package com.ashish.edvorarides.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ashish.edvorarides.screens.MainScreen
import com.ashish.edvorarides.viewmodles.MainViewModel
import com.ashish.mygithub.navigation.Screens


@Composable
fun NavGraph(viewModel: MainViewModel) {
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.NearestScreen.route) {
        composable(Screens.NearestScreen.route) {
            MainScreen(viewModel, navController)

        }
        composable(Screens.UpcomingScreen.route) {


        }
        composable(Screens.PastScreen.route) {

        }

    }


}