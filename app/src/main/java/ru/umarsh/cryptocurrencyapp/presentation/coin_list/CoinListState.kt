package ru.umarsh.cryptocurrencyapp.presentation.coin_list

import ru.umarsh.cryptocurrencyapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
