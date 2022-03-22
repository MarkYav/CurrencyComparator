package com.example.currencycomparator.currencyDetail.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.currencycomparator.currencyDetail.data.local.entity.RatesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RatesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(rates: RatesEntity)

    @Query("SELECT * FROM ratesentity WHERE currencyId = :currencyId")
    fun getCurrency(currencyId: String): Flow<List<RatesEntity>>

}