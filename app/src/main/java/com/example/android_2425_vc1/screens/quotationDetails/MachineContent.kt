package com.example.android_2425_vc1.screens.quotationDetails

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.android_2425_vc1.model.Machine
import com.example.android_2425_vc1.ui.utils.DetailSection
import com.example.android_2425_vc1.ui.utils.TableRow

@SuppressLint("DefaultLocale")
@Composable
fun MachineContent(machine: Machine) {
    Column(modifier = Modifier.padding(16.dp)) {
        DetailSection(label = "Serienummer:", machine.serialNumber)
        DetailSection(label = "Machine naam:", machine.name)
        DetailSection(label = "Type:", machine.category.name)

        Text(
            text = "Opties:",
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
        )
        machine.optionList.forEach { option ->
            Text(
                text = option.description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
            )
        }

        val totalPrice = machine.optionList.sumOf { option -> option.price }
        TableRow(label = "Prijs:", "€${String.format("%.2f", totalPrice)}")
    }
}