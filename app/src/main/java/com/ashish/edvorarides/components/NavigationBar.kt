package com.ashish.edvorarides.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ashish.edvorarides.R
import com.ashish.edvorarides.ui.theme.backgroundColor
import com.ashish.edvorarides.ui.theme.textLight
import com.ashish.edvorarides.viewmodles.MainViewModel

@Composable
fun NavNearest(navController: NavController,viewModel: MainViewModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = "Rides", fontSize = 12.sp, color = textLight, fontWeight = FontWeight.Normal)
        NavItem("Nearest", true){}
        NavItem(title = "Upcoming(${viewModel.upcomingRides()})"){}
        NavItem(title = "Past(${viewModel.pastRides()})"){}
        Row {
            Icon(painter = painterResource(id = R.drawable.ic_filter), contentDescription = "")
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Filters",
                fontSize = 12.sp,
                color = Color(0xFFf2f2f2),
                fontWeight = FontWeight.Normal
            )

        }


    }
}

@Composable
fun NavUpcoming(navController: NavController,viewModel: MainViewModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = "Rides", fontSize = 12.sp, color = textLight, fontWeight = FontWeight.Normal)
        NavItem("Nearest"){}
        NavItem(title = "Upcoming(${viewModel.upcomingRides()})", true){}
        NavItem(title = "Past(${viewModel.pastRides()})"){}
        Row {
            Icon(painter = painterResource(id = R.drawable.ic_filter), contentDescription = "")
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Filters",
                fontSize = 12.sp,
                color = Color(0xFFf2f2f2),
                fontWeight = FontWeight.Normal
            )

        }


    }
}

@Composable
fun NavPast(navController: NavController, viewModel: MainViewModel) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = backgroundColor),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = "Rides", fontSize = 12.sp, color = textLight, fontWeight = FontWeight.Normal)
        NavItem("Nearest"){}
        NavItem(title = "Upcoming(${viewModel.upcomingRides()})"){}
        NavItem(title = "Past(${viewModel.pastRides()})", true){}
        Row {
            Icon(painter = painterResource(id = R.drawable.ic_filter), contentDescription = "")
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Filters",
                fontSize = 12.sp,
                color = Color(0xFFf2f2f2),
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Composable
fun NavItem(title: String, selected: Boolean = false , onClick : () -> Unit) {
    val titleColor = if (selected) Color.White else textLight
    val titleWeight = if (selected) FontWeight.Bold else FontWeight.Normal
    val titleDecoration = if (selected) TextDecoration.Underline else TextDecoration.None

    Text(
        text = title,
        fontSize = 12.sp,
        color = titleColor,
        fontWeight = titleWeight,
        textDecoration = titleDecoration
     , modifier = Modifier.clickable { onClick() }
    )

}
