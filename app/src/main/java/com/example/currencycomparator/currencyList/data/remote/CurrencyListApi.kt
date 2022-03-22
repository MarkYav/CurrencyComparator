package com.example.currencycomparator.currencyList.data.remote

import com.example.currencycomparator.currencyList.data.dto.AllCurrenciesDto
import retrofit2.http.GET

interface CurrencyListApi {

    @GET("/v2/currencies")
    suspend fun getCurrencies(): AllCurrenciesDto

}