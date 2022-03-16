package com.ashish.edvorarides.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ashish.edvorarides.components.NavNearest
import com.ashish.edvorarides.components.RideCard
import com.ashish.edvorarides.components.TopBar
import com.ashish.edvorarides.data.api.RidesResponse
import com.ashish.edvorarides.data.model.Rides
import com.ashish.edvorarides.data.model.User
import com.ashish.edvorarides.viewmodles.MainViewModel
import com.ashish.mygithub.utils.RidesViewState
import com.ashish.mygithub.utils.UserViewState

@Composable
fun MainScreen(viewModel: MainViewModel , navController: NavController) {
    viewModel.getUser()
    Scaffold( modifier = Modifier.padding(20.dp) ,
        topBar = {
            val context = LocalContext.current

            when(val result = viewModel.startingState.collectAsState().value){

                     is UserViewState.Success -> {
                         TopBar(user = result.user)
                     }
                     is UserViewState.Error -> {

                         TopBar(user = User.fakeUser)
                         Toast.makeText(
                             context,
                             "Error ${result.exception}",
                             Toast.LENGTH_SHORT
                         ).show()
                     }
                     is UserViewState.Empty -> {
                         TopBar(user = User.fakeUser)
                         print("Empty state is empty }")

                     }
                     is UserViewState.Loading -> {
                         TopBar(user = User.fakeUser)
                         print("Loading state is loading }")

                     }

                 }
        },
        content = {
            val context = LocalContext.current
            viewModel.getAllRides()
            when(val result = viewModel.ridesState.collectAsState().value){

                is RidesViewState.Success -> {

                    NearestRides(
                        rides = result.allRides,
                        navController = navController,
                        viewModel = viewModel
                    )
                }
                is RidesViewState.Error -> {

                    Toast.makeText(
                        context,
                        "Error ${result.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is RidesViewState.Empty -> {
                    print("Empty state is empty }")

                }
                is RidesViewState.Loading -> {

                    print("Loading state is loading }")

                }

            }

        }
    )


}

@Composable
fun NearestRides(rides : RidesResponse , navController: NavController , viewModel: MainViewModel ) {
    Column(modifier = Modifier.fillMaxSize()) {
        NavNearest(navController,viewModel )
val ride = Rides.fakeRide()
        LazyColumn(
            modifier = Modifier
        ) {

//            items(rides.results) { item ->
//                RideCard(ridesItem = item)
//                Spacer(modifier = Modifier.heightIn(10.dp))
//            }\

            item { RideCard(ridesItem = ride) }

        }

    }
}

