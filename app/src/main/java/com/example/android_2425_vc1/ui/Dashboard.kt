package com.example.android_2425_vc1.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.BorderColor
import androidx.compose.material.icons.filled.DirectionsBus
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_2425_vc1.R

/**
 * column of 3,
 * top is a column of 2 (if salesman name is required by design)
 * center is a column of [ amount of pages = rows(len2) ] tall,
 * bottom is a row of [ ?-length ] of buttons
 *
 */
@Composable
fun Dashboard(modifier: Modifier = Modifier, salesman: String = "Unknown") {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        //top
        TopBannerDashBD(salesman)
        //center
        CenterDashBD(modifier = Modifier.weight(1f))
        //bottom
        BottomDashBD()
    }
}

@Composable
fun TopBannerDashBD(salesman: String = "Unknown") {

    Box(
        Modifier.background(colorResource(id = R.color.primary_300)).fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text (
                text = "DOZER",
                fontSize = 50.sp,

                )
            Text (
                text = "Welkom $salesman",
                fontSize = 12.sp
            )
        }
    }
}

/**
 * onze Dozer image is niet zo schaalbaar tot heel kleine groottes
 */
@Composable
fun CenterDashBD(modifier: Modifier = Modifier) {
    val dozerYellow = colorResource(id = R.color.primary_300)
//    val dozerIcon = painterResource(R.drawable.dozer_icon_no_text)
    Box(
        modifier = modifier
        .background(dozerYellow.copy(alpha = 0.3F))
        .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
            //verticalArrangement = Arrangement.Center
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
//                Image(
//                    painter = dozerIcon,
//                    contentDescription = "dozer icon",
//                    modifier = Modifier.size(50.dp)
//                )
                Icon(
                    imageVector = Icons.Filled.DirectionsBus,
                    contentDescription = "Machines link",
                    tint = Color.Black,
                    modifier = Modifier.size(50.dp)
                )
                Button(onClick = {/* TODO */}) {
                    Text(
                        text = "Machines",
                        fontSize = 24.sp
                    )
                }

            }
            Row(){
                Icon(
                    imageVector = Icons.Filled.AttachMoney,
                    contentDescription = "Offertes link",
                    tint = Color.Black,
                    modifier = Modifier.size(50.dp)
                )
                Button(onClick = {/* TODO */}) {
                    Text(
                        text = "Offertes",
                        fontSize = 24.sp
                    )
                }

            }
            Row(){
                Icon(
                    imageVector = Icons.Filled.BorderColor,
                    contentDescription = "Bestellingen link",
                    tint = Color.Black,
                    modifier = Modifier.size(50.dp)
                )
                Button(onClick = {/* TODO */}) {
                    Text(
                        text = "Bestellingen",
                        fontSize = 24.sp
                    )
                }

            }
            Row(){
                Icon(
                    imageVector = Icons.Filled.ArrowOutward,
                    contentDescription = "Ingeruilde Machines link",
                    tint = Color.Black,
                    modifier = Modifier.size(50.dp)
                )
                Button(onClick = {/* TODO */}) {
                    Text(
                        text = "Ingeruilde Machines",
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}

@Composable
fun BottomDashBD() {
    Box(
        Modifier.background(colorResource(id = R.color.primary_300)).fillMaxWidth()
        .alpha(0.5F)
    ){
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = "Back Arrow",
                tint = Color.Black,
                modifier = Modifier.size(50.dp)
                    .weight(1f)
            )
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Home Icon",
                tint = Color.Black,
                modifier = Modifier.size(50.dp)
                    .weight(1f)
            )
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = "Forward Arrow",
                tint = Color.Black,
                modifier = Modifier.size(50.dp)
                    .weight(1f)
                    .graphicsLayer(scaleX = -1f)
            )
        }
    }
}