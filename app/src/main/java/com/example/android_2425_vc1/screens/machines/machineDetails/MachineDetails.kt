package com.example.android_2425_vc1.screens.machines.machineDetails

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.android_2425_vc1.R
import com.example.android_2425_vc1.model.Machine
import com.example.android_2425_vc1.model.MachineCategory
import com.example.android_2425_vc1.model.Option
import com.example.android_2425_vc1.model.OptionCategory
import com.example.android_2425_vc1.screens.machines.MachinesUiState
import com.example.android_2425_vc1.utils.ReplyContentType

enum class MachineDetailsScreen() {
    Start,
    Info,
    Options
}

@Composable
fun MachineDetails(
    machineUiState: MachinesUiState,
    contentType: ReplyContentType,
    onBackPressed: () -> Unit,
    modifier: Modifier = Modifier,
    isFullScreen: Boolean = true,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = MachineDetailsScreen.Start.name
    ) {
        composable(route = MachineDetailsScreen.Start.name) {
            MachineDetailsStartScreen(
                machine = machineUiState.currentMachine,
                onClickOptions = { label ->
                    navController.navigate(
                        route = "${MachineDetailsScreen.Options.name}/${label}"
                    )
                },
                onGoBack = { navController.navigateUp() },
            )
        }
        composable(
            route = "${MachineDetailsScreen.Info.name}/{label}/{value}",
            arguments = listOf(
                navArgument("label") { type = NavType.ReferenceType },
                navArgument("value") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val label = backStackEntry.arguments?.getInt("label") ?: 0
            val value = backStackEntry.arguments?.getString("value") ?: ""
            MachineDetailsInfoScreen(
                title = label,
                value = value,
                onGoBack = {
                    navController.navigateUp()
                }
            )
        }
        composable(
            route = "${MachineDetailsScreen.Options.name}/{label}",
            arguments = listOf(
                navArgument("label") { type = NavType.ReferenceType }
            )
        ) { backStackEntry ->
            val label = backStackEntry.arguments?.getInt("label") ?: 0
            MachineOptionsScreen(
                title = label,
                optionsList = machineUiState.currentMachine.optionList,
                onGoBack = { navController.navigateUp() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMachineDetailsScreen() {
    // Mock data for MachinesUiState
    val mockMachine = Machine(
        id = 1,
        name = "Excavator",
        description = R.string.crane_liebherr_description,
        optionList = listOf(
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
        ),
        serialNumber = "number",
        category = MachineCategory.KRAAN,
        imageResourceId = R.drawable.ic_excavator_bobcat,
        brochureText = R.string.crane_liebherr_brochureText,
    )
    val mockMachineUiState = MachinesUiState(
        currentMachine = mockMachine
    )

    // Mock content type (you can choose what type of content you'd like to show)
    val contentType = ReplyContentType.LIST_AND_DETAIL

    // Simple back press handler for preview
    val onBackPressed: () -> Unit = {}

    // Preview the MachineDetails screen with mock data
    MachineDetails(
        machineUiState = mockMachineUiState,
        contentType = contentType,
        onBackPressed = onBackPressed,
        modifier = Modifier,
        isFullScreen = true
    )
}
