package com.example.routesetterlascade.navigators

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.routesetterlascade.screens.home_screen.ScreenHome
import com.example.routesetterlascade.screens.splash_screen.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun AppNavigation(){
    var showHome by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay(3000) // wait 3 seconds
        showHome = true
    }
    if(showHome){
        ScreenHome()
    }else{
        SplashScreen()
    }
}
