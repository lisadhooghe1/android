package com.example.android_2425_vc1.screens.quotationDetails

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.android_2425_vc1.model.Quotation
import com.example.android_2425_vc1.ui.utils.TableRow
import com.example.compose.secondaryContainerDarkMediumContrast

@Composable
fun GeneralContent(quotation: Quotation) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(48.dp)
    ) {
        TableRow(label = "Offertenummer:", value = quotation.quotationNumber)
        TableRow(label = "Datum:", value = quotation.date)
        TableRow(label = "Versie:", value = quotation.version)

        val statusColor = if (quotation.status == "goedgekeurd") {
            secondaryContainerDarkMediumContrast
        } else {
            Color.Red
        }
        TableRow(label = "Status:", value = quotation.status, textColor = statusColor)
    }
}
