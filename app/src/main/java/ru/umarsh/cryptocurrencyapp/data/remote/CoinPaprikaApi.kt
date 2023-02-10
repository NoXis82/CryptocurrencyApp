package ru.umarsh.cryptocurrencyapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import ru.umarsh.cryptocurrencyapp.data.remote.dto.CoinDetailDto
import ru.umarsh.cryptocurrencyapp.data.remote.dto.CoinDto


interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}