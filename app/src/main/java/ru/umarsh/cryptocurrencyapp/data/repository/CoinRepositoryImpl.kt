package ru.umarsh.cryptocurrencyapp.data.repository

import ru.umarsh.cryptocurrencyapp.data.remote.CoinPaprikaApi
import ru.umarsh.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import ru.umarsh.cryptocurrencyapp.data.remote.dto.CoinDto
import ru.umarsh.cryptocurrencyapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}