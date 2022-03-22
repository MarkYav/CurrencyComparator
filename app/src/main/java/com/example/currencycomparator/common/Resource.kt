package com.example.currencycomparator.common

sealed class Resource {
    object Success : Resource()
    data class Failure(val message: String, val reason: Exception) : Resource()
}