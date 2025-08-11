package com.example.routesetterlascade.screens.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

import com.example.routesetterlascade.custom.widgets.bottomsheet_widgets.HomeBottomSheet

import com.example.routesetterlascade.custom.widgets.homescreen_widgets.HomeScreenAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHome() {
    val scaffoldState=  rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        scaffoldState=scaffoldState,
        modifier = Modifier.background(Color.Transparent),
        sheetContent = {
            HomeBottomSheet()
        },
        sheetShape = RoundedCornerShape(0.dp),
        contentColor = Color.Transparent,
        sheetContainerColor = Color.Black,
        sheetPeekHeight = 200.dp
    ) {

        Image(
            painter = painterResource(id = com.example.routesetterlascade.R.drawable.maplocationimage),
            contentDescription = "Map Image",
            modifier = Modifier
                .fillMaxSize()
               , // apply scaffold's padding
            contentScale = androidx.compose.ui.layout.ContentScale.Crop // ensures it fully covers
        )
        Column {
            Spacer(

            modifier = Modifier.height(28.dp)
            )
            HomeScreenAppBar()
        }
    }
}
