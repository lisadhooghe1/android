package com.example.android_2425_vc1.screens.machines.machineDetails

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.android_2425_vc1.R
import com.example.android_2425_vc1.model.Option
import com.example.android_2425_vc1.model.OptionCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MachineOptionsScreen(
    @StringRes title: Int,
    optionsList: List<Option>,
    viewModel: MachineDetailsViewModel = viewModel(),
    onGoBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(title),
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onGoBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.goBack)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xfffff8e8)
                )
            )
        },
        containerColor = Color(0xfffff8e8)
    ) { innerpadding ->
        LazyColumn(
            modifier = Modifier.padding(innerpadding)
        ) {
            items(optionsList) { option ->
                OptionItem(
                    option = option,
                    viewModel = viewModel
                )
            }
        }
    }
}

@Composable
fun OptionItem(
    option: Option,
    viewModel: MachineDetailsViewModel
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = option.isChecked ,
            onCheckedChange = { viewModel.updateOptionChecked(option.code, it) }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = option.description,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "Prijs: €${String.format("%.2f", option.price)}",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun MachineOptionsScreenPreview() {
    // Mock list of options
    val mockOptions = listOf(
        Option(
            optionCategory = OptionCategory(id = 1, code = "CAT1", name = "Categorie 1"),
            code = "OPT1",
            description = "Optie 1 beschrijving",
            price = 100.0,
            isChecked = false,
            id = 1
        ),
        Option(
            optionCategory = OptionCategory(id = 2, code = "CAT2", name = "Categorie 2"),
            code = "OPT2",
            description = "Optie 2 beschrijving",
            price = 200.0,
            isChecked = false,
            id = 2
        )
    )

    // Preview the MachineOptionsScreen with mock data
    MachineOptionsScreen(
        title = R.string.machine_opties,  // Use any string resource ID
        optionsList = mockOptions,
        onGoBack = { /* Empty callback for preview */ }
    )
}

@Composable
@Preview(showBackground = true)
fun PreviewMachineOptionsScreen() {
    MachineOptionsScreenPreview()
}