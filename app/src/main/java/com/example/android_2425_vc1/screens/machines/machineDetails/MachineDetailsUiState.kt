package com.example.android_2425_vc1.screens.machines.machineDetails

import com.example.android_2425_vc1.data.LocalMachineDataProvider
import com.example.android_2425_vc1.model.Machine
import com.example.android_2425_vc1.model.Option

data class MachineDetailsUiState(
    val optionsList: List<Option> = emptyList(),
    val currentMachine: Machine = LocalMachineDataProvider.defaultMachine
)
