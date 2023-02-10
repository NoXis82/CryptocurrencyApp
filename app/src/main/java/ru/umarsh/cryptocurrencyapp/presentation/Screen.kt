package ru.umarsh.cryptocurrencyapp.presentation

sealed class Screen(val route: String) {
    object CoinListScree: Screen("coin_list_screen")
    object CoinDetailScree: Screen("coin_detail_screen")
}
