package com.example.android_2425_vc1.navigation

sealed class RootScreen(val route: String) {
    object Login : RootScreen("login_root")
//    object Dashboard : RootScreen("dashboard_root")
    object Machines : RootScreen("machines_root")
    object Quotations : RootScreen("quotations_root")
    object Orders : RootScreen("orders_root")
    object Settings : RootScreen("settings_root")
}

sealed class LeafScreen(val route: String) {
    object Login : LeafScreen("login")
//    object Dashboard : LeafScreen("dashboard")
    object Machines : LeafScreen("machines")
    object Quotations : LeafScreen("quotations")
    object Orders : LeafScreen("orders")
    object Settings : LeafScreen("settings")

    // Add nested screen routes if needed
    object MachineDetails : LeafScreen("machine_details")
    object QuotationDetails : LeafScreen("quotation_details")
    object OrderDetails : LeafScreen("order_details")
}