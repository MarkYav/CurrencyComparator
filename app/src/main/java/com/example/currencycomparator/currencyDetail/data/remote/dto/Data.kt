package com.example.currencycomparator.currencyDetail.data.remote.dto

data class Data(
    val currency: String,
    val rates: Map<String, String>
)