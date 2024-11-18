package com.example.android_2425_vc1.screens.quotationDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.android_2425_vc1.ui.utils.MenuItem
import com.example.android_2425_vc1.ui.utils.DropDownMenu


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuotationDetails(
    windowSize: WindowWidthSizeClass,
    viewModel: QuotationDetailViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val backgroundColor = if (uiState.isEditMode) Color(0xFFFAF7EF) else Color.White

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text("Offerte ${uiState.quotation.quotationNumber}")
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* Handle back navigation */ }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    },
                    actions = {
                        val offerteMenuItems = listOf(
                            MenuItem(
                                label = "Wijzigen",
                                onClick = { viewModel.toggleEditMode() }
                            ),
                            MenuItem(
                                label = "Verwijderen",
                                onClick = { /* Handle delete */ }
                            ),
                            MenuItem(
                                label = "Downloaden",
                                onClick = { /* Handle download */ }
                            ),
                            MenuItem(
                                label = "Bestelling maken",
                                onClick = { /* Handle order creation */ }
                            )
                        )
                        DropDownMenu(menuItems = offerteMenuItems)
                    },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                        containerColor = backgroundColor
                    )
                )
            },
            containerColor = backgroundColor
        ) { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                QuotationDetailTabsScreen(
                    quotation = uiState.quotation,
                    isEditMode = uiState.isEditMode,
                    backgroundColor = backgroundColor
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuotationDetailsPreview() {
    QuotationDetails(
        windowSize = WindowWidthSizeClass.Compact
    )
}

