package com.example.currencycomparator.currencyDetail.data.local.entity

import androidx.room.Entity

@Entity(primaryKeys = ["currencyId", "anotherCurrencyName"])
data class RatesEntity(
    val currencyId: String,
    val anotherCurrencyName: String,
    val exchangeRate: String
)
