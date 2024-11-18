package com.example.android_2425_vc1.screens.machines.machineDetails

import androidx.lifecycle.ViewModel
import com.example.android_2425_vc1.data.LocalMachineDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

open class MachineDetailsViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(
        MachineDetailsUiState(
            optionsList = LocalMachineDataProvider.defaultMachine.optionList,
            currentMachine = LocalMachineDataProvider.defaultMachine
        )
    )
    val uiState: StateFlow<MachineDetailsUiState> = _uiState

    open fun updateOptionChecked(optionCode: String, isChecked: Boolean) {
        _uiState.update { currentState ->
            val updatedOptions = currentState.optionsList.map { option ->
                if(option.code == optionCode) {
                    option.copy(isChecked = isChecked)
                } else {
                    option
                }
            }
            currentState.copy(optionsList = updatedOptions)
        }
    }
}