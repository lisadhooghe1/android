package com.example.android_2425_vc1.screens.machines

import com.example.android_2425_vc1.data.LocalMachineDataProvider
import com.example.android_2425_vc1.model.Machine

data class MachinesUiState(
    val machines: List<Machine> = emptyList(),
    val currentMachine: Machine = LocalMachineDataProvider.defaultMachine,
    val isShowingHomepage: Boolean = true,
    val isShowingFilterPage: Boolean = false,
    val selectedMachine: Machine? = null,
    val isShowingListPage: Boolean = true
)