package com.example.currencycomparator.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.currencycomparator.currencyDetail.presentation.CurrencyDetailScreen
import com.example.currencycomparator.currencyList.presentation.CurrencyListScreen
import com.example.currencycomparator.main.ui.theme.CurrencyComparatorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyComparatorTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CurrencyListScreen.route
                    ) {
                        composable(route = Screen.CurrencyListScreen.route) {
                            CurrencyListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CurrencyDetailScreen.route
                                    + "/{currencyId}"
                                    + "/{currencyName}"
                        ) {
                            CurrencyDetailScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}