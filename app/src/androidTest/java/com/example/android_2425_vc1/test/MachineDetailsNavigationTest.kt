package com.example.android_2425_vc1.test

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.android_2425_vc1.screens.machines.machineDetails.MachineDetails
import com.example.android_2425_vc1.screens.machines.machineDetails.MachineDetailsScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MachineDetailsNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setupMachineDetailsNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            MachineDetails(
                windowSize = WindowWidthSizeClass.Compact,
                navController = navController
            )
        }
    }

    /**
     * TESTS FOR NAVIGATION TO A CERTAIN SCREEN
     */
    @Test
    fun machineDetailsNavHost_verifyStartDestination() {
        navController.assertCurrentRouteName(MachineDetailsScreen.Start.name)
    }

    @Test
    fun machineDetailsNavHost_clickSerienummer_navigatesToInfoScreen() {
        composeTestRule
            .onNodeWithStringId(com.example.android_2425_vc1.R.string.machine_serienummer)
            .performClick()
        navController.assertCurrentRouteName("${MachineDetailsScreen.Info.name}/{label}/{value}")
    }

    @Test
    fun machineDetailsNavHost_clickCategorie_navigatesToInfoScreen() {
        composeTestRule
            .onNodeWithStringId(com.example.android_2425_vc1.R.string.machine_categorie)
            .performClick()
        navController.assertCurrentRouteName("${MachineDetailsScreen.Info.name}/{label}/{value}")
    }

    @Test
    fun machineDetailsNavHost_clickBeschrijving_navigatesToInfoScreen() {
        composeTestRule
            .onNodeWithStringId(com.example.android_2425_vc1.R.string.machine_beschrijving)
            .performClick()
        navController.assertCurrentRouteName("${MachineDetailsScreen.Info.name}/{label}/{value}")
    }

    @Test
    fun machineDetailsNavHost_clickBrochureTekst_navigatesToInfoScreen() {
        composeTestRule
            .onNodeWithStringId(com.example.android_2425_vc1.R.string.machine_brochure_teksten)
            .performClick()
        navController.assertCurrentRouteName("${MachineDetailsScreen.Info.name}/{label}/{value}")
    }

    @Test
    fun machineDetailsNavHost_clickOpties_navigatesToOptionsScreen() {
        composeTestRule
            .onNodeWithStringId(com.example.android_2425_vc1.R.string.machine_opties)
            .performClick()
        navController.assertCurrentRouteName("${MachineDetailsScreen.Options.name}/{label}")
    }

    /**
     * TESTS FOR RETURNING TO START SCREEN
     */
    @Test
    fun machineDetailsNavHost_clickGoBackOnInfoScreen_navigatesBackToStartScreen() {
        navigateToInfoScreen()
        composeTestRule
            .onNodeWithContentDescriptionId(com.example.android_2425_vc1.R.string.goBack)
            .performClick()
        navController.assertCurrentRouteName(MachineDetailsScreen.Start.name)
    }

    @Test
    fun machineDetailsNavHost_clickGoBackOnOptionsScreen_navigatesBackToStartScreen() {
        navigateToOptionsScreen()
        composeTestRule
            .onNodeWithContentDescriptionId(com.example.android_2425_vc1.R.string.goBack)
            .performClick()
        navController.assertCurrentRouteName(MachineDetailsScreen.Start.name)
    }

    /**
     * Helper function to navigate to Info screen
     */
    private fun navigateToInfoScreen() {
        composeTestRule
            .onNodeWithStringId(com.example.android_2425_vc1.R.string.machine_serienummer)
            .performClick()
    }

    /**
     * Helper function to navigate to Options screen
     */
    private fun navigateToOptionsScreen() {
        composeTestRule
            .onNodeWithStringId(com.example.android_2425_vc1.R.string.machine_opties)
            .performClick()
    }
}