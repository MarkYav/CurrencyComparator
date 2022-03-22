package com.example.currencycomparator.currencyList.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.currencycomparator.currencyList.data.dto.CurrencyDto

@Database(entities = [CurrencyDto::class], version = 1)
abstract class CurrencyDatabase: RoomDatabase() {

    abstract val dao: CurrencyDao

}