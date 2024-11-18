package com.example.android_2425_vc1.screens.order

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Orders(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    Scaffold(
        bottomBar = {

        },
    ) { innerPadding ->
        Text(
            text = "Orders",
            modifier = Modifier.padding(innerPadding)
        )
    }
}