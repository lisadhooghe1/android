package com.example.android_2425_vc1.screens.settings

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun Settings(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    Scaffold(
        bottomBar = {

        },
    ) { innerPadding ->
        Text(
            text = "Settings",
            modifier = Modifier.padding(innerPadding)
        )
    }
}