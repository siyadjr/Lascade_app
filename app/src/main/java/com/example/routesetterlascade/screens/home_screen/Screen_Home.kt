package com.example.routesetterlascade.screens.home_screen


import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.routesetterlascade.custom.widgets.bottomsheet_widgets.HomeBottomSheet
import kotlinx.coroutines.launch


import com.example.routesetterlascade.custom.widgets.homescreen_widgets.HomeScreenAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenHome() {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()
    var currentScreenIndex by remember { mutableStateOf(0) }

    // Get density here (inside Composable)
    val density = LocalDensity.current

    // Define peek heights for different indices
    val peekHeight = when (currentScreenIndex) {
        0 -> 200.dp
        1 -> 200.dp
        2 -> 300.dp
        3 -> 280.dp
        5 -> 430.dp
        6 -> 800.dp  // For index 6, set to 800dp
        else -> 500.dp
    }

    // Animate peek height changes
    val animatedPeekHeight by animateDpAsState(
        targetValue = peekHeight,
        animationSpec = tween(durationMillis = 170),
        label = "peekHeight"
    )

    // When index changes to 6, expand the bottom sheet to show full content


    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.background(Color.Transparent),
        sheetContent = {
            HomeBottomSheet(
                onCurrentScreenChanged = { newIndex ->
                    currentScreenIndex = newIndex
                }
            )
        },
        sheetShape = RoundedCornerShape(0.dp),
        contentColor = Color.Transparent,
        sheetContainerColor = Color.Black,
        sheetPeekHeight = animatedPeekHeight,
        sheetSwipeEnabled = true // Allow user to drag the sheet
    ) {
        Image(
            painter = painterResource(id = com.example.routesetterlascade.R.drawable.maplocationimage),
            contentDescription = "Map Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )
        Column {
            Spacer(modifier = Modifier.height(28.dp))
            HomeScreenAppBar()
        }
    }
}


