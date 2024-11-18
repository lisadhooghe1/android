package com.example.android_2425_vc1.screens.machines

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.android_2425_vc1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterPage(
    onBackClick: () -> Unit, modifier: Modifier = Modifier
) {
    Scaffold(topBar = {
        TopAppBar(title = { Text("Filters") }, navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_button)
                )
            }
        })
    }) { innerPadding ->
        // Add your filter options here
        Column(modifier = modifier.padding(innerPadding)) {
            Text("Filter Option 1")
            Text("Filter Option 2")
            // Add more filter options as needed
        }
    }
}