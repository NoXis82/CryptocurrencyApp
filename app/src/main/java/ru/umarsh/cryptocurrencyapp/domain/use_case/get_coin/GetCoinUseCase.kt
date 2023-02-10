package ru.umarsh.cryptocurrencyapp.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import ru.umarsh.cryptocurrencyapp.common.Resource
import ru.umarsh.cryptocurrencyapp.domain.model.CoinDetail
import ru.umarsh.cryptocurrencyapp.domain.repository.CoinRepository
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coinDetail = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(data = coinDetail))
        } catch (e: HttpException) {
            emit(Resource.Error("Ошибка соединения с сервисом"))
        } catch (e: IOException) {
            emit(Resource.Error("Проверти соединение с интернетом"))
        }
    }
}