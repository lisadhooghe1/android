package com.example.android_2425_vc1.screens.quotationDetails

import com.example.android_2425_vc1.data.LocalMachineDataProvider
import com.example.android_2425_vc1.model.Quotation

data class QuotationDetailsUiState (
    val quotation: Quotation = Quotation("808099-o", "15.05.2024", "3", "goedgekeurd",
        LocalMachineDataProvider.defaultMachine
    ),
    val isEditMode: Boolean = false
)