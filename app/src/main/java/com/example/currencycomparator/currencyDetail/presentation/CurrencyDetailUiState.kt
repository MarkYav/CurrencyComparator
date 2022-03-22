package com.example.currencycomparator.currencyDetail.presentation

import com.example.currencycomparator.currencyDetail.data.local.entity.RatesEntity

data class CurrencyDetailUiState(
    val isLoading: Boolean = false,
    val currencyId: String,
    val currencyName: String,
    val rates: List<RatesEntity> = emptyList(),
    val error: String = ""
)