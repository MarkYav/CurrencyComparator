package com.example.currencycomparator.di

import android.app.Application
import androidx.room.Room
import com.example.currencycomparator.common.Constants
//import com.example.currencycomparator.currencyDetail.data.local.CurrencyExchangeRateConverter
//import com.example.currencycomparator.currencyDetail.data.local.CurrencyExchangeRateDao
//import com.example.currencycomparator.currencyDetail.data.local.CurrencyExchangeRateDatabase
import com.example.currencycomparator.currencyDetail.data.local.RatesDao
import com.example.currencycomparator.currencyDetail.data.local.RatesDatabase
import com.example.currencycomparator.currencyDetail.data.remote.CurrencyDetailApi
import com.example.currencycomparator.currencyList.data.local.CurrencyDao
import com.example.currencycomparator.currencyList.data.local.CurrencyDatabase
import com.example.currencycomparator.currencyList.data.remote.CurrencyListApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCurrencyListApi(): CurrencyListApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyListApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCurrencyDetailApi(): CurrencyDetailApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyDetailApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDataDao(
        dataDatabase: CurrencyDatabase
    ): CurrencyDao {
        return dataDatabase.dao
    }

    @Provides
    @Singleton
    fun provideCurrencyExchangeRateDao(
        currencyExchangeRateDatabase: RatesDatabase
    ): RatesDao {
        return currencyExchangeRateDatabase.dao
    }

    @Provides
    @Singleton
    fun provideDataDatabase(
        app: Application
    ): CurrencyDatabase {
        return Room.databaseBuilder(
            app,
            CurrencyDatabase::class.java,
            "currency_data_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCurrencyExchangeRateDatabase(
        app: Application
    ): RatesDatabase {
        return Room.databaseBuilder(
            app,
            RatesDatabase::class.java,
            "currency_exchange_database"
        ).build()
    }

}