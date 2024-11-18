package com.example.android_2425_vc1.screens.quotationDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import com.example.android_2425_vc1.model.Quotation
import com.example.android_2425_vc1.screens.quotationDetails.edit.EditClientTab
import com.example.android_2425_vc1.screens.quotationDetails.edit.EditGeneralTab
import com.example.android_2425_vc1.screens.quotationDetails.edit.EditMachineTab

@Composable
fun QuotationDetailTabsScreen(
    quotation: Quotation,
    isEditMode: Boolean,
    backgroundColor: Color
) {
    val tabTitles = listOf("Algemeen", "Machine", "Klant")
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            indicator = { tabPositions ->
                SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = Color.Black
                )
            },
            modifier = Modifier.background(backgroundColor)
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray,
                    modifier = Modifier
                        .background(backgroundColor
                        )
                )
            }
        }

        when (selectedTabIndex) {
            0 -> if (isEditMode) EditGeneralTab(quotation) else GeneralContent(quotation)
            1 -> if (isEditMode) EditMachineTab(quotation.machine) else MachineContent(quotation.machine)
            2 -> if (isEditMode) EditClientTab() else ClientContent()
        }
    }
}
