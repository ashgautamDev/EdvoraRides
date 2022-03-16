package com.ashish.edvorarides.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashish.edvorarides.data.model.Rides
import com.ashish.edvorarides.utils.LoadingNetworkImage

@Composable
fun RideCard(ridesItem: Rides) {
    val distance = 0
    val stationPath = ridesItem.station_path.toString()

    Column(modifier = Modifier
        .heightIn(max = 430.dp)
        .background(
            color = Color.Black,
            shape = RoundedCornerShape(10.dp)
        )
        .padding(27.dp)) {
        ridesItem.map_url?.let {
            LoadingNetworkImage(
                url = it,
                Modifier
                    .height(148.dp)
                    .fillMaxWidth()
                    .background(shape = RoundedCornerShape(5.dp), color = Color.Gray)
            )
        }

        Spacer(modifier = Modifier.height(17.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            ridesItem.city?.let { ChipCard(it) }
            ridesItem.state?.let { ChipCard(it) }
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextItem(title = "Ride Id", value = ridesItem.id.toString())
        Spacer(modifier = Modifier.height(12.dp))
        TextItem(title = "Origin Station", value = ridesItem.origin_station_code.toString())
        Spacer(modifier = Modifier.height(12.dp))
        TextItem(title = "station_path", value = ridesItem.station_path.toString())
        Spacer(modifier = Modifier.height(12.dp))
        ridesItem.date?.let { TextItem(title = "Date", value = it) }
        Spacer(modifier = Modifier.height(12.dp))
        TextItem(title = "Distance", value = distance.toString() )





    }


}

@Composable
fun ChipCard(name: String) {
    Card(modifier = Modifier
        .height(23.dp)
        .background(shape = RoundedCornerShape(16.dp), color = Color.Gray) , backgroundColor = Color.Black) {
        Text(
            text = name,
            fontSize = 12.sp,
            color = Color.White ,
            modifier = Modifier.padding(vertical = 4.dp , horizontal = 10.dp)
        )
        
    }
}

@Composable
fun TextItem(title : String , value : String) {
    val string = buildString {
        append(title)
        append(":")
        append(value)
    }
    Text(text =string , fontWeight = FontWeight.Bold , fontSize = 18.sp)

}
