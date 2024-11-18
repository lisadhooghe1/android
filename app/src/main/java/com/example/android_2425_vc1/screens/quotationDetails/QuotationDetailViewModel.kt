package com.example.android_2425_vc1.screens.quotationDetails

import androidx.lifecycle.ViewModel
import com.example.android_2425_vc1.data.LocalMachineDataProvider
import com.example.android_2425_vc1.model.Quotation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

open class QuotationDetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        QuotationDetailsUiState(
            quotation = Quotation("808099-o", "15.05.2024", "3", "goedgekeurd", LocalMachineDataProvider.defaultMachine),
            isEditMode = false
        )
    )

    val uiState: StateFlow<QuotationDetailsUiState> = _uiState

//    open fun updateQuotation(quotation: Quotation) {
//        _uiState.update {
//            it.copy(quotation = quotation)
//        }
//    }

    open fun toggleEditMode() {
        _uiState.update {
            it.copy(isEditMode = !it.isEditMode)
        }
    }

}