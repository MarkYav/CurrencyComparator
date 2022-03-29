package com.example.currencycomparator.currencyDetail.data.repository

import com.example.currencycomparator.common.Resource
import com.example.currencycomparator.currencyDetail.data.local.RatesDao
import com.example.currencycomparator.currencyDetail.data.local.entity.RatesEntity
import com.example.currencycomparator.currencyDetail.data.remote.CurrencyDetailApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CurrencyDetailRepository @Inject constructor(
    private val api: CurrencyDetailApi,
    private val dao: RatesDao
) {

    fun getCurrencyExchangeRatesById(currencyId: String): Flow<List<RatesEntity>> {
        return dao.getCurrency(currencyId = currencyId)
    }

    suspend fun updateCurrencyExchangeRatesById(coinId: String): Resource {
        return try {
            val currencyExchangeRates = api
                .getCurrencyExchangeRatesById(coinId = coinId)
                .data

            currencyExchangeRates.rates.forEach { (currencyId, currencyExchangeRate) ->
                CoroutineScope(Dispatchers.IO).launch {
                    if (currencyExchangeRates.currency != currencyId) {
                        dao.insert(
                            RatesEntity(
                                currencyId = currencyExchangeRates.currency,
                                anotherCurrencyName = currencyId,
                                exchangeRate = currencyExchangeRate
                            )
                        )
                    }
                }
            }

            Resource.Success
        } catch (e: HttpException) {
            Resource.Failure(
                message = e.localizedMessage ?: "An unexpected error occurred.",
                reason = e
            )
        } catch (e: IOException) {
            Resource.Failure(
                message = "Couldn"t reach server. Check your internet connection.",
                reason = e
            )
        } catch (e: Exception) {
            Resource.Failure(
                message = e.localizedMessage ?: "An unexpected error occurred.",
                reason = e
            )
        }
    }

}
