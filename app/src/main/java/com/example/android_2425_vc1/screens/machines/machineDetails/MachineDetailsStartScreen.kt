package com.example.android_2425_vc1.screens.machines.machineDetails

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.dimensionResource
import com.example.android_2425_vc1.R
import com.example.android_2425_vc1.model.Machine

/**
 * Show machine details screen
 * [machine] is the specific machine for which details are requested
 */
@Composable
fun MachineDetailsStartScreen(
    machine: Machine,
    onClickOptions: (Int) -> Unit,
    onGoBack: () -> Unit,
) {
    Scaffold(
        topBar = { MachineDetailsTopBar(name = machine.name, onGoBack = onGoBack) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MachineImage(
                imageResourceId = machine.imageResourceId,
                name = machine.name
            )
            MachinePropertiesList(
                machine = machine,
                onClickOptions = onClickOptions
            )
        }
    }
}

/**
 * A top bar with a "go back" button that returns to the overview of machines
 * [name] is the name of the specific machine
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MachineDetailsTopBar(
    name: String,
    onGoBack: () -> Unit,
) {
    TopAppBar(
        navigationIcon = {
            IconButton(
                onClick = { onGoBack() }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Go back"
                )
            }
        },
        title = {
            Text(
                text = name,
                fontWeight = FontWeight.Bold
            )
        },
        colors = topAppBarColors(
            titleContentColor = Color(0xff191923)
        )
    )
}

/**
 * Show the image of the specific machine
 * [imageResourceId] is the id of the image in the res/drawable folder
 * [name] is the name of the specific machine to use as content description
 */
@Composable
fun MachineImage(
    imageResourceId: Int,
    name: String,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(imageResourceId),
        contentScale = ContentScale.Crop,
        contentDescription = name
    )
}

/**
 *  Shows a list of buttons to navigate to a specific property of a machine
 *  [machine] is the specific machine for which details are requested
 */
@Composable
fun MachinePropertiesList(
    machine: Machine,
    onClickOptions: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.detail_card_inner_padding)),
    ) {
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
        MachineOptionsButton(
            label = R.string.machine_opties,
            onClick = onClickOptions
        )
    }
}

@Composable
fun MachineOptionsButton(
    @StringRes label: Int,
    onClick: (Int) -> Unit
) {
    Button(
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xfff9e5be),
            contentColor = Color(0xff191923)
        ),
        onClick = { onClick(label) },
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(label),
                style = MaterialTheme.typography.titleLarge
            )
            Icon(
                imageVector = Icons.Filled.Info,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun TopBarPreview() {
    MachineDetailsTopBar(
        name = "Graafmachine x",
        onGoBack = {}
    )
}

@Preview
@Composable
fun MachineImagePreview() {
    MachineImage(
        imageResourceId = R.drawable.graafmachine,
        name = "Machine"
    )
}
