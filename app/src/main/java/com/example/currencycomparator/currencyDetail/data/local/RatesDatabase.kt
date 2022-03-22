package com.example.currencycomparator.currencyDetail.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.currencycomparator.currencyDetail.data.local.entity.RatesEntity

@Database(entities = [RatesEntity::class], version = 1)
abstract class RatesDatabase : RoomDatabase() {

    abstract val dao: RatesDao

}