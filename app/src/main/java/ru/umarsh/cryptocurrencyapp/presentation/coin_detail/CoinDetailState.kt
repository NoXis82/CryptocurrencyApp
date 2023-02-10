package ru.umarsh.cryptocurrencyapp.presentation.coin_detail

import ru.umarsh.cryptocurrencyapp.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
