package com.example.currencycomparator.currencyList.presentation.uiState

import com.example.currencycomparator.currencyList.data.dto.CurrencyDto

data class CurrencyListUiState(
    val isLoading: Boolean = false,
    val currencies: List<CurrencyDto> = emptyList(),
    val error: String = "",
    val searchWidgetUiState: SearchWidgetUiState = SearchWidgetUiState.CLOSED,
    val searchText: String = ""
)

