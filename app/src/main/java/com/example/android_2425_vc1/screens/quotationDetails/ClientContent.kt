package com.example.android_2425_vc1.screens.quotationDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android_2425_vc1.ui.utils.DetailSection

@Composable
fun ClientContent() {
    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        DetailSection(label = "Klant:", value = "Bram Vermeulen")
        DetailSection(label = "Email:", value = "BramVermeulen@outlook.com")
        DetailSection(label = "Telefoonnummer:", value = "+32 2 123 45 67")
        DetailSection(label = "BTW-nummer:", value = "BE0123 456 789")
        DetailSection(label = "Leveradres:", value = "Kastanjelaan 12, 1000 Brussel, Belgie")
        DetailSection(label = "Factuuradres:", value = "Kastanjelaan 12, 1000 Brussel, Belgie")
    }
}

