package com.example.android_2425_vc1.screens.quotationDetails.edit

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.android_2425_vc1.model.Machine
import com.example.android_2425_vc1.ui.utils.TableRow

@SuppressLint("DefaultLocale")
@Composable
fun EditMachineTab(
    machine: Machine,
    //onMachineChange: (Machine) -> Unit
) {
    var serialNumber by remember { mutableStateOf(machine.serialNumber) }
    var name by remember { mutableStateOf(machine.name) }
    var category by remember { mutableStateOf(machine.category.name) }
    var optionList by remember { mutableStateOf(machine.optionList) }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = serialNumber,
            onValueChange = {
                serialNumber = it
                //onMachineChange(machine.copy(serialNumber = it))
            },
            label = { Text("Serienummer") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                //onMachineChange(machine.copy(name = it))
            },
            label = { Text("Machine naam") },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        )

        OutlinedTextField(
            value = category,
            onValueChange = {
                category = it
                //onMachineChange(machine.copy(category = machine.category.copy(name = it)))
            },
            label = { Text("Type") },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        )

        machine.optionList.take(2).forEachIndexed { index, option ->
            OutlinedTextField(
                value = option.description,
                onValueChange = {},
                label = { Text("Optie ${index + 1}") },
                modifier = Modifier.fillMaxWidth(),
                readOnly = true
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        val totalPrice = optionList.sumOf { it.price }
        TableRow(label = "Totale Prijs:", value = "€${String.format("%.2f", totalPrice)}")
    }
}

