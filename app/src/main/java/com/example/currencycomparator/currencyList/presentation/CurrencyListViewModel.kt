package com.example.currencycomparator.currencyList.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencycomparator.common.Resource
import com.example.currencycomparator.currencyList.data.repository.CurrencyListRepository
import com.example.currencycomparator.currencyList.presentation.uiState.CurrencyListUiState
import com.example.currencycomparator.currencyList.presentation.uiState.SearchWidgetUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    private val currencyListRepository: CurrencyListRepository
) : ViewModel() {

    private var _state = mutableStateOf(CurrencyListUiState(isLoading = true))
    val state: State<CurrencyListUiState> = _state

    init {
        getCurrencies()
        updateCurrencies()
    }

    private fun getCurrencies(searchText: String = _state.value.searchText) {
        if (searchText.isBlank()) {
            currencyListRepository.getAllCurrencies().onEach {
                _state.value = _state.value.copy(currencies = it)
            }.launchIn(viewModelScope)
        } else {
            currencyListRepository.getSomeCurrencies(searchText).onEach {
                _state.value = _state.value.copy(currencies = it)
            }.launchIn(viewModelScope)
        }
    }

    fun updateCurrencies() = viewModelScope.launch {
        _state.value = _state.value.copy(isLoading = true, error = "")
        val resource = currencyListRepository.updateCurrencies()
        _state.value = _state.value.copy(isLoading = false)
        if (resource is Resource.Failure) {
            _state.value = _state.value.copy(error = resource.message)
        }
    }

    fun updateSearchWidgetState(newValue: SearchWidgetUiState) {
        _state.value = _state.value.copy(searchWidgetUiState = newValue)
        if (newValue == SearchWidgetUiState.CLOSED) {
            updateSearchTextState(newValue = "")
        }
    }

    fun updateSearchTextState(newValue: String) {
        _state.value = _state.value.copy(searchText = newValue)
        getCurrencies()
    }

}