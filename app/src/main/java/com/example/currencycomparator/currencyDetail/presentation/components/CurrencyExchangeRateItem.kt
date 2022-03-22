package com.example.currencycomparator.currencyDetail.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.currencycomparator.currencyDetail.data.local.entity.RatesEntity

@Composable
fun CurrencyExchangeRateItem(rate: RatesEntity) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        /*Text(text = rate.currencyId)
        Text(text = rate.exchangeRate.take(10))
        Text(text = rate.anotherCurrencyName)*/

        Text(text = "1 ${rate.currencyId} = ${rate.exchangeRate.take(10)} ${rate.anotherCurrencyName}")
    }
}