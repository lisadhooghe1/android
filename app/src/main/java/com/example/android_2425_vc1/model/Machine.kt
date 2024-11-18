package com.example.android_2425_vc1.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Data model for Machine
 */
data class Machine(
    val id: Int,
    val serialNumber: String,
    val name: String,
    val category: MachineCategory,
    @DrawableRes val imageResourceId: Int,
    @StringRes val description: Int,
    @StringRes val brochureText: Int,
    val optionList: List<Option>
)

enum class MachineCategory {
    UNKNOWN,
    RUPSMACHINE,
    MOBIELE_KRANEN,
    BULLDOZER,
    GRONDVERDRINGER,
    WIELLOADER,
    KRAAN,
    TRACER,
    TELESCOOP,
    SNELHEIDSGRAAFMACHINE
}

data class Option(
    val id: Int,
    val code: String,
    val description: String,
    val price: Double,
    val optionCategory: OptionCategory,
    val isChecked: Boolean = false
)

data class OptionCategory(
    val id: Int,
    val code: String,
    val name: String
)
