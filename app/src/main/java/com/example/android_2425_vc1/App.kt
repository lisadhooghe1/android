package com.example.android_2425_vc1

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.PrecisionManufacturing
import androidx.compose.material.icons.filled.RequestQuote
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.android_2425_vc1.navigation.AppNavGraph
import com.example.android_2425_vc1.navigation.RootScreen
import com.example.android_2425_vc1.utils.ReplyContentType
import com.example.android_2425_vc1.utils.ReplyNavigationType


@Composable
fun App(
    modifier: Modifier = Modifier,
    windowSize: WindowWidthSizeClass,
) {
    val navController = rememberNavController()
    val currentSelectedScreen by navController.currentScreenAsState()
    val currentRoute by navController.currentRouteAsState()
    val contentType: ReplyContentType
    val navigationType: ReplyNavigationType

// Show the bottom app bar only for these routes
    val bottomNavRoutes = listOf(
        RootScreen.Machines.route,
        RootScreen.Quotations.route,
        RootScreen.Orders.route,
        RootScreen.Settings.route
    )

    val appState = rememberSaveable(stateSaver = AppStateSaver) {
        mutableStateOf(AppState())
    }

    when (windowSize) {
        WindowWidthSizeClass.Compact -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Medium -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }

        WindowWidthSizeClass.Expanded -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_AND_DETAIL
        }

        else -> {
            navigationType = ReplyNavigationType.BOTTOM_NAVIGATION
            contentType = ReplyContentType.LIST_ONLY
        }
    }

    Scaffold(
        bottomBar = {
            // Show bottomNavBar only for specific routes
            if (currentRoute == null || bottomNavRoutes.contains(currentRoute)) {
                BottomNavBar(
                    navController = navController,
                    currentSelectedScreen = currentSelectedScreen
                )
            }

        },
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            AppNavGraph(
                navController,
                appState = appState,
                modifier = modifier,
                contentType = contentType,
            )
        }
    }
}

@Composable
private fun BottomNavBar(
    navController: NavController,
    currentSelectedScreen: RootScreen
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
    ) {
        NavigationBarItem(
            selected = currentSelectedScreen == RootScreen.Machines,
            onClick = { navController.navigateToRootScreen(RootScreen.Machines) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.Machines))
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.PrecisionManufacturing, contentDescription = null
                )
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.White
            ),
        )
        NavigationBarItem(
            selected = currentSelectedScreen == RootScreen.Quotations,
            onClick = { navController.navigateToRootScreen(RootScreen.Quotations) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.Quotations))
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.RequestQuote, contentDescription = null
                )
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.White
            ),
        )
        NavigationBarItem(
            selected = currentSelectedScreen == RootScreen.Orders,
            onClick = { navController.navigateToRootScreen(RootScreen.Orders) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.Orders))
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Inventory,
                    contentDescription = null
                )
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.White
            ),
        )
        NavigationBarItem(
            selected = currentSelectedScreen == RootScreen.Settings,
            onClick = { navController.navigateToRootScreen(RootScreen.Settings) },
            alwaysShowLabel = true,
            label = {
                Text(text = stringResource(id = R.string.Settings))
            },
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null
                )
            },
            colors = NavigationBarItemDefaults.colors(
                indicatorColor = Color.White
            ),
        )
    }
}

@Stable
@Composable
private fun NavController.currentScreenAsState(): State<RootScreen> {
    val selectedItem = remember { mutableStateOf<RootScreen>(RootScreen.Machines) }
    DisposableEffect(key1 = this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            when {
                destination.hierarchy.any { it.route == RootScreen.Machines.route } -> {
                    selectedItem.value = RootScreen.Machines
                }

                destination.hierarchy.any { it.route == RootScreen.Quotations.route } -> {
                    selectedItem.value = RootScreen.Quotations
                }

                destination.hierarchy.any { it.route == RootScreen.Orders.route } -> {
                    selectedItem.value = RootScreen.Orders
                }

                destination.hierarchy.any { it.route == RootScreen.Settings.route } -> {
                    selectedItem.value = RootScreen.Settings
                }
            }

        }
        addOnDestinationChangedListener(listener)
        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }
    return selectedItem
}

@Stable
@Composable
private fun NavController.currentRouteAsState(): State<String?> {
    val selectedItem = remember { mutableStateOf<String?>(null) }
    DisposableEffect(this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            selectedItem.value = destination.route
        }
        addOnDestinationChangedListener(listener)

        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }
    return selectedItem
}

private fun NavController.navigateToRootScreen(rootScreen: RootScreen) {
    navigate(rootScreen.route) {
        launchSingleTop = true
        restoreState = true
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
    }
}