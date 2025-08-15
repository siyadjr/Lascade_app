package com.example.routesetterlascade.data


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RouteItem(
    routeName: String,
    isSelected: Boolean,
    onSelect: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                color = Color(0xFF2C2C2E),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onSelect() }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = routeName,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            maxLines = 1
        )

        if (isSelected) {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(color = Color.Black, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Selected",
                    tint = Color(0xFFB97FFF),
                    modifier = Modifier.size(14.dp)
                )
            }
        } else {
            Box(
                modifier = Modifier
                    .size(24.dp)
                    .background(Color.Transparent, CircleShape)
                    .border(2.dp, color = Color.Black, CircleShape)
            )
        }
    }
}
data class Location(
    val name: String,
    val description: String
)

// Enum for map styles
enum class MapStyle(val displayName: String) {
    CLASSIC("Classic"),
    BLUEPRINT("Blueprint"),
    NIGHT("Night")
}

// Default locations function
fun getDefaultLocations(): List<Location> {
    return listOf(
        Location("New York", "New York, United States"),
        Location("Heathrow LHR", "London, United Kingdom"),
        Location("Stansted STN", "London, United Kingdom"),
        Location("Mumbai BOM", "Mumbai, India"),
        Location("Delhi DEL", "Delhi, India"),
    )
}