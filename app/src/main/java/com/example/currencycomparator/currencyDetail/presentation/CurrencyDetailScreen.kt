package com.example.currencycomparator.currencyDetail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.currencycomparator.common.components.ErrorMessageTop
import com.example.currencycomparator.currencyDetail.presentation.components.CurrencyExchangeRateItem

@Composable
fun CurrencyDetailScreen(
    navController: NavController,
    viewModel: CurrencyDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = state.currencyName) }) }
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
                    onRefresh = viewModel::updateRates
                )
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "(${state.currencyId}) ${state.currencyName}",
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center
            )
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.rates) { rate ->
                    CurrencyExchangeRateItem(rate = rate)
                }
            }
        }
    }
}