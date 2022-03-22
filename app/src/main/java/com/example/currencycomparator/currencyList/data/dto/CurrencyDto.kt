package com.example.currencycomparator.currencyList.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CurrencyDto(
    @PrimaryKey
    val id: String,
    @SerializedName("min_size")
    val minSize: String,
    val name: String
)