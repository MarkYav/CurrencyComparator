package com.example.currencycomparator.currencyList.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.currencycomparator.currencyList.data.dto.CurrencyDto
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(data: List<CurrencyDto>)

    @Query("SELECT * FROM currencydto")
    fun getData(): Flow<List<CurrencyDto>>

    @Query("SELECT * FROM currencydto WHERE id LIKE '%' || :query  || '%' OR name LIKE '%' || :query  || '%'")
    fun getData(query: String): Flow<List<CurrencyDto>>

    @Query("DELETE FROM currencydto")
    suspend fun deleteData()

}