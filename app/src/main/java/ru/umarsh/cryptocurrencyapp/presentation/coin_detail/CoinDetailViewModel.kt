package ru.umarsh.cryptocurrencyapp.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import ru.umarsh.cryptocurrencyapp.common.Constants
import ru.umarsh.cryptocurrencyapp.common.Resource
import ru.umarsh.cryptocurrencyapp.domain.use_case.get_coin.GetCoinUseCase
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    stateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        stateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {
            getCoinById(it)
        }
    }

    private fun getCoinById(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        coin = result.data
                    )
                }
                is Resource.Error -> {
                    _state.value =
                        _state.value.copy(error = result.message ?: "Не известная ошибка...")
                }
                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}