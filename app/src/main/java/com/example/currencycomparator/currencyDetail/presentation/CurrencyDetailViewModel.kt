package com.example.currencycomparator.currencyDetail.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencycomparator.common.Resource
import com.example.currencycomparator.currencyDetail.data.repository.CurrencyDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
//import com.example.currencycomparator.currencyDetail.data.repository.CurrencyDetailRepository
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyDetailViewModel @Inject constructor(
    private val currencyDetailRepository: CurrencyDetailRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val currencyId = savedStateHandle.get<String>("currencyId") ?: throw IllegalArgumentException()
    private val currencyName = savedStateHandle.get<String>("currencyName") ?: throw IllegalArgumentException()

    private var _state = mutableStateOf(
        CurrencyDetailUiState(currencyId = currencyId, currencyName = currencyName)
    )
    val state: State<CurrencyDetailUiState> = _state

    init {
        currencyDetailRepository.getCurrencyExchangeRatesById(currencyId = currencyId).onEach { CurrencyExchangeRateDto ->
            _state.value = _state.value.copy(rates = CurrencyExchangeRateDto)
        }.launchIn(viewModelScope)

        updateRates()
    }

    fun updateRates(currencyId: String = this.currencyId) = viewModelScope.launch {
        _state.value = _state.value.copy(isLoading = true, error = "")
        val resource = currencyDetailRepository.updateCurrencyExchangeRatesById(currencyId)
        _state.value = _state.value.copy(isLoading = false)
        if (resource is Resource.Failure) {
            _state.value = _state.value.copy(error = resource.message)
        }
    }

}