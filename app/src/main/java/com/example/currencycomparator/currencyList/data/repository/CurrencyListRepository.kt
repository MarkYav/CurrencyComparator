package com.example.currencycomparator.currencyList.data.repository

import com.example.currencycomparator.common.Resource
import com.example.currencycomparator.currencyList.data.dto.CurrencyDto
import com.example.currencycomparator.currencyList.data.local.CurrencyDao
import com.example.currencycomparator.currencyList.data.remote.CurrencyListApi
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CurrencyListRepository @Inject constructor(
    private val api: CurrencyListApi,
    private val dao: CurrencyDao
) {

    fun getAllCurrencies(): Flow<List<CurrencyDto>> {
        return dao.getData()
    }

    fun getSomeCurrencies(query: String): Flow<List<CurrencyDto>> {
        return dao.getData(query = query)
    }

    suspend fun updateCurrencies(): Resource {
        return try {
            val currencies = api.getCurrencies().data
            dao.insertData(currencies)
            Resource.Success
        } catch (e: HttpException) {
            Resource.Failure(
                message = e.localizedMessage ?: "An unexpected error occurred.",
                reason = e
            )
        } catch (e: IOException) {
            Resource.Failure(
                message = "Couldn't reach server. Check your internet connection.",
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