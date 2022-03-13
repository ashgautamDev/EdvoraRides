package com.ashish.edvorarides.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashish.edvorarides.data.model.User
import com.ashish.edvorarides.utils.LoadingNetworkImage

@Composable
fun TopAppBar(user: User) {
    Row(
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth()
            .background(color = Color.Black)
            .padding(vertical = 16.dp, horizontal = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Edvora",
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Row(
         horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = user.name,
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
LoadingNetworkImage(url = user.url ,  Modifier
    .size(24.dp)
    .background(shape = CircleShape, color = Color.Gray))


        }

    }

}