package com.example.currencycomparator.currencyList.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.currencycomparator.common.components.ErrorMessageTop
import com.example.currencycomparator.currencyList.presentation.components.CurrencyListItem
import com.example.currencycomparator.currencyList.presentation.components.MainAppBar
import com.example.currencycomparator.currencyList.presentation.uiState.SearchWidgetUiState
import com.example.currencycomparator.main.Screen

@Composable
fun CurrencyListScreen(
    navController: NavController,
    viewModel: CurrencyListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            MainAppBar(
                searchWidgetUiState = state.searchWidgetUiState,
                searchTextState = state.searchText,
                onTextChange = {
                    viewModel.updateSearchTextState(newValue = it)
                },
                onCloseClicked = {
                    viewModel.updateSearchWidgetState(newValue = SearchWidgetUiState.CLOSED)
                },
                onSearchTriggered = {
                    viewModel.updateSearchWidgetState(newValue = SearchWidgetUiState.OPENED)
                }
            )
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize()
        ) {
            if (state.isLoading) {
                LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            }
            if (state.error.isNotBlank()) {
                ErrorMessageTop(
                    errorMessage = state.error,
                    onRefresh = viewModel::updateCurrencies
                )
            }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.currencies) { currency ->
                    CurrencyListItem(currency = currency) { currency ->
                        navController.navigate(
                            Screen.CurrencyDetailScreen.route
                                    + "/${currency.id}"
                                    + "/${currency.name}"
                        )
                    }
                }
            }
        }
    }
}