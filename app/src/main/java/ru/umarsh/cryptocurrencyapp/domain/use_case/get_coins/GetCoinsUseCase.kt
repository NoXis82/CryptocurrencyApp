package ru.umarsh.cryptocurrencyapp.domain.use_case.get_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.umarsh.cryptocurrencyapp.common.Resource
import ru.umarsh.cryptocurrencyapp.domain.model.Coin
import ru.umarsh.cryptocurrencyapp.domain.repository.CoinRepository
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(data = coins))
        } catch (e: HttpException) {
            emit(Resource.Error("Ошибка соединения с сервисом", data = emptyList()))
        } catch (e: IOException) {
            emit(Resource.Error("Проверти соединение с интернетом", data = emptyList()))
        }
    }
}