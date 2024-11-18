package com.example.android_2425_vc1.model

data class Quotation(
    val quotationNumber: String,
    val date: String,
    val version: String,
    val status: String,
    val machine: Machine
)