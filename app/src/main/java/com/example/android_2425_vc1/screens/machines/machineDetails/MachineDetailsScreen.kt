package com.example.android_2425_vc1.screens.machines.machineDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_2425_vc1.R
import com.example.android_2425_vc1.model.Machine
import com.example.android_2425_vc1.model.MachineCategory
import com.example.android_2425_vc1.model.Option
import com.example.android_2425_vc1.model.OptionCategory
import com.example.android_2425_vc1.screens.machines.MachinesUiState
import com.example.android_2425_vc1.utils.ReplyContentType

@Composable
fun MachinesDetailsScreen(
    machineUiState: MachinesUiState,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    contentType: ReplyContentType,
) {
    Scaffold(
        topBar = {
            MachineDetailsScreenTopBar(
                onBackButtonClicked = onBackPressed,
                machinesUiState = machineUiState,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }
    ) { innerPadding ->
        Box(
            modifier = modifier
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                if (contentType == ReplyContentType.LIST_AND_DETAIL) {
                    ReplyListAndDetailContent(
                        machineUiState = machineUiState,
                    )
                } else {
                    ReplyListOnlyContent(
                        machineUiState = machineUiState,
                    )
                }
            }
        }
    }
}

@Composable
fun ReplyListOnlyContent(
    machineUiState: MachinesUiState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = WindowInsets.safeDrawing.asPaddingValues(),
    ) {
        item {
            MachineDetailsCard(
                machine = machineUiState.currentMachine,
                modifier = Modifier.fillMaxWidth()
            )
        }
        item {
            MachineOptions(
                options = machineUiState.currentMachine.optionList,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun ReplyListAndDetailContent(
    machineUiState: MachinesUiState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                MachineDetailsCard(
                    machine = machineUiState.currentMachine,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                MachineOptions(
                    options = machineUiState.currentMachine.optionList,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun MachineDetailsScreenTopBar(
    onBackButtonClicked: () -> Unit,
    machinesUiState: MachinesUiState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            onClick = onBackButtonClicked,
            modifier = Modifier
                .padding(horizontal = dimensionResource(R.dimen.detail_topbar_back_button_padding_horizontal))
                .background(MaterialTheme.colorScheme.surface, shape = CircleShape),
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = stringResource(id = R.string.back_button)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = dimensionResource(R.dimen.detail_subject_padding_end)),
        ) {
            Text(
                text = machinesUiState.currentMachine.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun MachineDetailsCard(
    machine: Machine,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.detail_card_inner_padding)),
    ) {
        MachineImage(
            imageResourceId = machine.imageResourceId,
            name = machine.name
        )
        Spacer(modifier = Modifier.height(dimensionResource(R.dimen.detail_content_padding_top)))
        Text(
            text = stringResource(R.string.machine_serienummer),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.detail_content_padding_top),
            ),
        )
        Text(
            text = machine.serialNumber,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(
                bottom = dimensionResource(R.dimen.detail_expanded_subject_body_spacing),
                start = dimensionResource(R.dimen.detail_card_content_padding),
            ),
        )
        Text(
            text = stringResource(R.string.machine_type),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.detail_content_padding_top),
            ),
        )
        Text(
            text = machine.category.toString(),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(
                bottom = dimensionResource(R.dimen.detail_expanded_subject_body_spacing),
                start = dimensionResource(R.dimen.detail_card_content_padding),
            ),
        )
        Text(
            text = stringResource(R.string.machine_beschrijving),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.detail_content_padding_top),
            ),
        )
        Text(
            text = machine.description.toString(),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(
                bottom = dimensionResource(R.dimen.detail_expanded_subject_body_spacing),
                start = dimensionResource(R.dimen.detail_card_content_padding),
            ),
        )
        Text(
            text = stringResource(R.string.machine_brochure_teksten),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.detail_content_padding_top),
            ),
        )
        Text(
            text = machine.brochureText.toString(),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(
                bottom = dimensionResource(R.dimen.detail_expanded_subject_body_spacing),
                start = dimensionResource(R.dimen.detail_card_content_padding),
            ),
        )
    }
}

@Composable
fun MachineOptions(
    options: List<Option>,
    modifier: Modifier = Modifier,
) {
    if (options.isEmpty()) {
        Text(
            text = "Geen opties beschikbaar",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(dimensionResource(R.dimen.detail_expanded_subject_body_spacing))
        )
    } else {
        Column(
            modifier = modifier
                .padding(
                    start = dimensionResource(R.dimen.detail_card_inner_padding))
        ) {
            Text(
                text = stringResource(R.string.machine_opties),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.detail_expanded_subject_body_spacing))
            )

            options.forEach { option ->
                Column(
                    modifier = Modifier
                        .padding(bottom = dimensionResource(R.dimen.detail_expanded_subject_body_spacing))
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "${option.optionCategory.code} - ${option.optionCategory.name}",
                        style = MaterialTheme.typography.bodyLarge,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.detail_card_content_padding),
                        ),
                    )
                    Column(
                        modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.detail_card_inner_padding)
                        )
                    ) {
                        Text(
                            text = option.code,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = "${option.description} - €${option.price}",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true,  widthDp = 1000)
@Composable
fun PreviewMachinesDetailsScreen() {
    // Mock data for preview
    val exampleOptions = listOf(
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

    val exampleMachine = Machine(
        id = 1,
        name = "Voorbeeld Machine",
        serialNumber = "12345",
        category = MachineCategory.KRAAN,
        description = R.string.crane_liebherr_description,
        brochureText = R.string.crane_liebherr_brochureText,
        imageResourceId = R.drawable.ic_excavator_bobcat, // Gebruik een bestaand drawable-resourcemateriaal
        optionList = exampleOptions
    )

    val machineUiState = MachinesUiState(
        currentMachine = exampleMachine
    )

    MachinesDetailsScreen(
        machineUiState = machineUiState,
        onBackPressed = {},
        contentType = ReplyContentType.LIST_AND_DETAIL,
    )
}
