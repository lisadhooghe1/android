package com.example.android_2425_vc1

import com.example.android_2425_vc1.screens.machines.machineDetails.MachineDetailsViewModel
import org.junit.Test

class MachineDetailsViewModelTest {

    private val viewModel = MachineDetailsViewModel()

    @Test
    fun machineDetailsViewModel_CheckAnOption_IsCheckedUpdatedToTrue() {
        var currentMachineDetailsUiState = viewModel.uiState.value
        var currentOptionList = currentMachineDetailsUiState.optionsList
        viewModel.updateOptionChecked(
            optionCode = currentOptionList[0].code,
            isChecked = true
        )
        currentMachineDetailsUiState = viewModel.uiState.value
        currentOptionList = currentMachineDetailsUiState.optionsList
        assert(currentOptionList[0].isChecked)
    }

}