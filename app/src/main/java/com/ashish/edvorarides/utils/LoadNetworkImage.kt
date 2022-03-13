package com.ashish.edvorarides.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun LoadingNetworkImage(url: String , modifier: Modifier = Modifier) {

    val painter = rememberCoilPainter(
        request = url
    )
    Image(
        painter = painter,
        contentDescription = "",
        modifier = modifier
    )
}