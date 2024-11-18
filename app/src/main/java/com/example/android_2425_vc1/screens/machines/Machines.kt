package com.example.android_2425_vc1.screens.machines


import MachinesViewModel
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.compose.primaryContainerLight
import com.example.android_2425_vc1.R
import com.example.android_2425_vc1.model.Machine
import com.example.android_2425_vc1.screens.machines.machineDetails.MachineDetails
import com.example.android_2425_vc1.screens.machines.machineDetails.MachinesDetailsScreen
import com.example.android_2425_vc1.utils.ReplyContentType

/**
 * Main composable that serves as container
 * which displays content according to [uiState] and [windowSize]
 */
@Composable
fun Machines(
    contentType: ReplyContentType,
    onBackPressed: () -> Unit,
    viewModel: MachinesViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            if (uiState.isShowingHomepage) {
                MachinesAppBar(
                    onBackButtonClick = { navController.popBackStack() },
                    onFilterClick = { viewModel.navigateToFilterPage() },
                    contentType = contentType,
                    modifier = modifier,
                )
            }
        }
    ) { innerPadding ->
        when (contentType) {
            ReplyContentType.LIST_ONLY -> {
                if (uiState.isShowingHomepage) {
                    MachinesListOnlyContent(
                        machineUiState = uiState,
                        onMachineCardPressed = {machine: Machine ->
                            viewModel.updateDetailsScreenStates(
                                machine = machine
                            )
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                } else {
                    MachineDetails(
                        machineUiState = uiState,
                        contentType = contentType,
                        onBackPressed = onBackPressed,
                        modifier = modifier,
                        isFullScreen = true,
                    )
                }
            }
            // Overzicht van machines
            ReplyContentType.LIST_AND_DETAIL -> {
                if (uiState.isShowingHomepage) {
                    MachinesListOnlyContent(
                        machineUiState = uiState,
                        onMachineCardPressed = {machine: Machine ->
                            viewModel.updateDetailsScreenStates(
                                machine = machine
                            )
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                } else {
                    MachinesDetailsScreen(
                        machineUiState = uiState,
                        onBackPressed = onBackPressed,
                        modifier = modifier,
                        contentType = contentType,
                    )

                }
            }
        }
    }
}

/**
 * Composable that displays the topBar and displays back button if back navigation is possible.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MachinesAppBar(
    onBackButtonClick: () -> Unit,
    onFilterClick: () -> Unit,
    contentType: ReplyContentType,
    modifier: Modifier = Modifier
) {
    val isShowingDetailPage = contentType == ReplyContentType.LIST_AND_DETAIL
    var isSearchVisible by remember { mutableStateOf(false) }

    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.list_fragment_label),
                fontWeight = FontWeight.Bold,
            )
        },
        actions = {
            if (isSearchVisible) {
                // TODO search functionality
//                TextField(
//                    value = searchQuery,
//                    onValueChange = { searchQuery = it },
//                    placeholder = { Text("Search...") },
//                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
//                    modifier = Modifier.fillMaxWidth(0.5f)
//                )

            } else {
                IconButton(onClick = { isSearchVisible = true }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search_button)
                    )
                }
            }
            // TODO filter functionality
            IconButton(onClick = onFilterClick) {
                Icon(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = stringResource(R.string.filter_button)
                )
            }
        },
        modifier = modifier,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MachinesListOnlyContent(
    machineUiState: MachinesUiState,
    onMachineCardPressed: (Machine) -> Unit,
    modifier: Modifier = Modifier
) {
    val machines = machineUiState.machines

    val configuration = LocalConfiguration.current
    val screenWidthDp = configuration.screenWidthDp
    val columnCount = when {
        screenWidthDp < 600 -> 1
        screenWidthDp < 840 -> 2
        else -> 3
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(columnCount),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items(machines, key = { machine -> machine.id }) { machine ->
            MachinesListItem(
                machine = machine,
                selected = false,
                onCardClick = {
                    onMachineCardPressed(machine)
                },
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MachinesListItem(
    machine: Machine,
    selected: Boolean,
    onCardClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = if (selected) {
                MaterialTheme.colorScheme.primaryContainer
            } else {
                primaryContainerLight.copy(alpha = 0.3f)
            }
        ),
        onClick = onCardClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.machine_list_item_inner_padding)),
        ) {
            Image(
                painter = painterResource(machine.imageResourceId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = machine.name,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(
                    top = dimensionResource(R.dimen.machine_list_item_header_subject_spacing),
                )
            )
        }
    }
}

// ---- ---- ---- ----
// Previews
// ---- ---- ---- ----
/*
@Preview
@Composable
fun MachinesPreview() {
    Android2425vc1Theme {
        // Mock data and state for the preview
        val mockMachines = LocalMachineDataProvider.getMachinesData()
        val mockMachine = LocalMachineDataProvider.defaultMachine

        var selectedItem by remember { mutableIntStateOf(0) }
        val items = listOf("Machines", "Offers", "Orders", "More")
        val icons = listOf(
            Icons.Filled.Build, Icons.Filled.Description, Icons.Filled.Outbox, Icons.Filled.Apps
        )

        Scaffold(topBar = {
            MachinesAppBar(
                isShowingListPage = true, // Assuming showing list page in this preview
                onBackButtonClick = {}, // No-op for preview
                onFilterClick = {},
                windowSize = WindowWidthSizeClass.Compact // Use a compact window size for preview
            )
        }, bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(icon = { Icon(icons[index], contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index })
                }
            }
        }) { innerPadding ->
            MachinesList(
                machines = mockMachines,
                onClick = {}, // No-op for preview
                modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.padding_medium)),
                contentPadding = innerPadding,
            )
        }
    }
}

@Preview
@Composable
fun MachinesListItemPreview() {
    Android2425vc1Theme {
        MachinesListItem(machine = LocalMachineDataProvider.defaultMachine, onItemClick = {})
    }
}


@Preview
@Composable
fun MachinesListPreview() {
    Android2425vc1Theme {
        Surface {
            MachinesList(
                machines = LocalMachineDataProvider.getMachinesData(),
                onClick = {},
            )
        }
    }
}

@Preview(device = "spec:width=1280dp,height=800dp,dpi=240")
@Composable
fun MachinesListAndDetailsPreview() {
    Android2425vc1Theme {
        Surface {
            MachinesListAndDetail(
                machines = LocalMachineDataProvider.getMachinesData(),
                selectedMachine = LocalMachineDataProvider.getMachinesData().getOrElse(0) {
                    LocalMachineDataProvider.defaultMachine
                },
                onClick = {},
                onBackPressed = {},
            )
        }
    }
}
*/

