package com.example.currencycomparator.currencyList.presentation.components

import androidx.compose.runtime.Composable
import com.example.currencycomparator.currencyList.presentation.uiState.SearchWidgetUiState

@Composable
fun MainAppBar(
    searchWidgetUiState: SearchWidgetUiState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchTriggered: () -> Unit
) {
    when (searchWidgetUiState) {
        SearchWidgetUiState.CLOSED -> {
            DefaultAppBar(
                onSearchClicked = onSearchTriggered
            )
        }
        SearchWidgetUiState.OPENED -> {
            SearchAppBar(
                text = searchTextState,
                onTextChange = onTextChange,
                onCloseClicked = onCloseClicked,
            )
        }
    }
}