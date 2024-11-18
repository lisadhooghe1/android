package com.example.android_2425_vc1.screens.quotationDetails.edit

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android_2425_vc1.model.Quotation

@Composable
fun EditGeneralTab(
    quotation: Quotation,
    //onQuotationChange: (Quotation) -> Unit
) {
    var quotationNumber by remember { mutableStateOf(quotation.quotationNumber) }
    var date by remember { mutableStateOf(quotation.date) }
    var version by remember { mutableStateOf(quotation.version) }
    var status by remember { mutableStateOf(quotation.status) }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = quotationNumber,
            onValueChange = {
                quotationNumber = it
                //onQuotationChange(quotation.copy(quotationNumber = it))
            },
            label = { Text("Offertenummer") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = date,
            onValueChange = {
                date = it
                //onQuotationChange(quotation.copy(date = it))
            },
            label = { Text("Datum") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = version,
            onValueChange = {
                version = it
                //onQuotationChange(quotation.copy(version = it))
            },
            label = { Text("Versie") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = status,
            onValueChange = {
                status = it
                //onQuotationChange(quotation.copy(status = it))
            },
            label = { Text("Status") },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        )
    }
}
