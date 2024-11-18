package com.example.android_2425_vc1.ui.utils

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class MenuItem(
    val label: String,
    val onClick: () -> Unit
)

@Composable
fun DropDownMenu(
    menuItems: List<MenuItem>,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    val bgcolor = Color(0xFFFAF7EF)

    // Button to open the dropdown menu
    IconButton(onClick = { expanded = true }, modifier = modifier) {
        Icon(Icons.Default.MoreVert, contentDescription = "More options")
    }


    AnimatedVisibility(
        visible = expanded,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            containerColor = bgcolor,
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .fillMaxWidth(0.5f)
        ) {
            menuItems.forEach { item ->
                DropdownMenuItem(
                    text = { Text(item.label, modifier = Modifier.padding(horizontal = 16.dp)) },
                    onClick = {
                        expanded = false
                        item.onClick()
                    }
                )
            }
        }
    }
}
