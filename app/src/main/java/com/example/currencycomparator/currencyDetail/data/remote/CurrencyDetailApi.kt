package com.example.currencycomparator.currencyDetail.data.remote

import com.example.currencycomparator.currencyDetail.data.remote.dto.AllCurrencyExchangeRatesDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyDetailApi {

    @GET("/v2/exchange-rates")
    suspend fun getCurrencyExchangeRatesById(
        @Query("currency") coinId: String
    ): AllCurrencyExchangeRatesDto

}