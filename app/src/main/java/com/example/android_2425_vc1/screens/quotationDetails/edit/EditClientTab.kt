package com.example.android_2425_vc1.screens.quotationDetails.edit

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown

@Composable
fun EditClientTab() {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            OutlinedTextField(
                value = "Voornaam",
                onValueChange = {},
                label = { Text("Voornaam") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            OutlinedTextField(
                value = "Familienaam",
                onValueChange = {},
                label = { Text("Familienaam") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            OutlinedTextField(
                value = "Email",
                onValueChange = {},
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            OutlinedTextField(
                value = "Telefoonnummer",
                onValueChange = {},
                label = { Text("Telefoonnummer") },
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            OutlinedTextField(
                value = "BTW-nummer",
                onValueChange = {},
                label = { Text("BTW-nummer") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            Text(
                text = "Facturatieadres",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 24.dp)
            )
        }

        item {
            val selectedCountry = remember { mutableStateOf("Belgie") }
            CountryDropdown(selectedCountry.value) { selectedCountry.value = it }
        }

        item {
            OutlinedTextField(
                value = "Straatnaam",
                onValueChange = {},
                label = { Text("Straatnaam") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                OutlinedTextField(
                    value = "Stad",
                    onValueChange = {},
                    label = { Text("Stad") },
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = "Postcode",
                    onValueChange = {},
                    label = { Text("Postcode") },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        item {
            Text(
                text = "Leveradres",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(top = 24.dp)
            )
        }

        item {
            val selectedShippingCountry = remember { mutableStateOf("Belgie") }
            CountryDropdown(selectedShippingCountry.value) { selectedShippingCountry.value = it }
        }

        item {
            OutlinedTextField(
                value = "Straatnaam",
                onValueChange = {},
                label = { Text("Straatnaam") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        item {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                OutlinedTextField(
                    value = "Stad",
                    onValueChange = {},
                    label = { Text("Stad") },
                    modifier = Modifier.weight(1f)
                )
                OutlinedTextField(
                    value = "Postcode",
                    onValueChange = {},
                    label = { Text("Postcode") },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}


@Composable
fun CountryDropdown(selectedCountry: String, onCountrySelected: (String) -> Unit) {
    val expanded = remember { mutableStateOf(false) }
    val countries = listOf("Belgie", "Nederland", "Duitsland", "Frankrijk")

    Box {
        OutlinedTextField(
            value = selectedCountry,
            onValueChange = {},
            label = { Text("Land") },
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { expanded.value = true }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = null
                    )
                }
            }
        )
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            countries.forEach { country ->
                DropdownMenuItem(
                    text = { Text(country) },
                    onClick = {
                        onCountrySelected(country)
                        expanded.value = false
                    }
                )
            }
        }
    }
}
