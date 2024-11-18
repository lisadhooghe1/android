package com.example.android_2425_vc1.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.android_2425_vc1.AppState
import com.example.android_2425_vc1.screens.login.Login
import com.example.android_2425_vc1.screens.machines.Machines
import com.example.android_2425_vc1.screens.order.Orders
import com.example.android_2425_vc1.screens.quotation.QuotationDetails
import com.example.android_2425_vc1.screens.quotation.Quotations
import com.example.android_2425_vc1.screens.settings.Settings
import com.example.android_2425_vc1.utils.ReplyContentType

@Composable
fun AppNavGraph(
    navController: NavHostController,
    appState: MutableState<AppState>,
    contentType: ReplyContentType,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = RootScreen.Login.route
    ) {
        addLoginRoute(navController, appState, contentType, modifier)
        addMachinesRoute(navController, contentType, modifier)
        addQuotationsRoute(navController)
        addOrdersRoute(navController)
        addSettingsRoute(navController)
    }
}

// Login navigation
private fun NavGraphBuilder.addLoginRoute(
    navController: NavController,
    appState: MutableState<AppState>,
    contentType: ReplyContentType,
    modifier: Modifier
) {
    composable(route = RootScreen.Login.route) {
        Login(
            login = { credentials ->
                appState.value = appState.value.copy(isLoggedIn = true)
                Log.i("LOGIN", "App state login with token: ${credentials.accessToken}")

                // Navigate to Machines screen after successful login
                navController.navigate(RootScreen.Machines.route) {
                    popUpTo(RootScreen.Login.route) { inclusive = true }
                    launchSingleTop = true
                }
            },
            modifier = modifier,
            contentType = contentType,
        )
    }
}

// ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----
// Machines navigation
// ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----
private fun NavGraphBuilder.addMachinesRoute(
    navController: NavController,
    contentType: ReplyContentType,
    modifier: Modifier
) {
    composable(route = RootScreen.Machines.route) {
        Machines(
            contentType = contentType,
            onBackPressed = { navController.popBackStack() },
            viewModel = viewModel(),
            modifier = modifier,
        )
    }
}


// ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----
// Quotations navigation
// ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----
//private fun NavGraphBuilder.addQuotationsRoute(navController: NavController) {
//    navigation(
//        route = RootScreen.Quotations.route,
//        startDestination = LeafScreen.Quotations.route
//    ) {
//        showQuotations(navController)
//        showQuotation(navController)
//    }
//}
//
//private fun NavGraphBuilder.showQuotations(navController: NavController) {
//    composable(route = LeafScreen.Quotations.route) {
//        Quotations(
//            showDetail = {
//                navController.navigate(LeafScreen.QuotationDetails.route)
//            }
//        )
//    }
//}
//
//private fun NavGraphBuilder.showQuotation(navController: NavController) {
//    composable(route = LeafScreen.QuotationDetails.route) {
//        QuotationDetails(
//            onBack = {
//                navController.navigateUp()
//            }
//        )
//    }
//}
// ---- ---- ---- ----  ---- ---- ---- ----
private fun NavGraphBuilder.addQuotationsRoute(navController: NavController) {
    composable(route = RootScreen.Quotations.route) {
        Quotations(
            showDetail = {
                navController.navigate(LeafScreen.QuotationDetails.route)
            }
        )
    }
    composable(route = LeafScreen.QuotationDetails.route) {
        QuotationDetails(
            onBack = {
                navController.navigateUp()
            }
        )
    }
}

// ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----
// Orders navigation
// ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----
private fun NavGraphBuilder.addOrdersRoute(
    navController: NavController,
) {
    composable(route = RootScreen.Orders.route) {
        Orders()
    }
}

// ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----
// Settings navigation
// ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----  ---- ---- ---- ----
private fun NavGraphBuilder.addSettingsRoute(
    navController: NavController,
) {
    composable(route = RootScreen.Settings.route) {
        Settings()
    }
}
