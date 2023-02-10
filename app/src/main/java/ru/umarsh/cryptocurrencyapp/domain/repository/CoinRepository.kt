package ru.umarsh.cryptocurrencyapp.domain.repository

import ru.umarsh.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import ru.umarsh.cryptocurrencyapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}