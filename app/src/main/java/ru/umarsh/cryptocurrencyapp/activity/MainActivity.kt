package ru.umarsh.cryptocurrencyapp.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.umarsh.cryptocurrencyapp.presentation.Screen
import ru.umarsh.cryptocurrencyapp.presentation.coin_detail.CoinDetailScreen
import ru.umarsh.cryptocurrencyapp.presentation.coin_list.components.CoinListScreen
import ru.umarsh.cryptocurrencyapp.presentation.ui.theme.CryptocurrencyAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScree.route
                    ) {
                        composable(route = Screen.CoinListScree.route) {
                            CoinListScreen(navController)
                        }
                        composable(route = Screen.CoinDetailScree.route + "/{coinId}") {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}