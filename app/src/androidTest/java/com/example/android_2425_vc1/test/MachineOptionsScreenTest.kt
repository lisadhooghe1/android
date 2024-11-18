package com.example.android_2425_vc1.test

import androidx.activity.ComponentActivity
import androidx.annotation.StringRes
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.android_2425_vc1.model.Option
import com.example.android_2425_vc1.model.OptionCategory
import com.example.android_2425_vc1.screens.machines.machineDetails.MachineDetailsViewModel
import com.example.android_2425_vc1.screens.machines.machineDetails.MachineOptionsScreen
import org.junit.Rule
import org.junit.Test

class MachineOptionsScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    /**
     * TEST TO CHECK IF THE OPTIONS ARE SHOWN ON THE OPTION SCREEN
     */
    @Test
    fun machineOptionsScreen_verifyContent() {
        @StringRes val stringResTitle = com.example.android_2425_vc1.R.string.machine_opties
        val optionsList = listOf(
            Option(
                id = 1,
                code = "OPT1",
                description = "Option 1",
                price = 10.0,
                optionCategory = OptionCategory(id = 1, code = "CAT1", name = "Category 1"),
                isChecked = false
            )
        )
        val viewModel = MachineDetailsViewModel()
        val onGoBack = {}

        composeTestRule.setContent {
            MachineOptionsScreen(
                title = stringResTitle,
                optionsList = optionsList,
                viewModel = viewModel,
                onGoBack = onGoBack
            )
        }

        optionsList.forEach { option ->
            composeTestRule.onNodeWithText(option.description).assertIsDisplayed()
        }
    }

}