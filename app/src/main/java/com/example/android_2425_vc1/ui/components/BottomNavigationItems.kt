//package com.example.android_2425_vc1.ui.components
//
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Inventory
//import androidx.compose.material.icons.filled.PrecisionManufacturing
//import androidx.compose.material.icons.filled.RequestQuote
//import androidx.compose.material.icons.filled.Settings
//import androidx.compose.ui.graphics.vector.ImageVector
//import com.example.android_2425_vc1.R
//import com.example.android_2425_vc1.navigation.LeafScreen
//
//sealed class BottomNavigationItems(
//    val route: String,
//    val title: String? = null,
//    val icon: ImageVector? = null,
//    val iconResId: Int? = null
//) {
//    object Machines : BottomNavigationItems(
//        route = LeafScreen.Machines.route,
//        title = "Machines",
//        icon = Icons.Default.PrecisionManufacturing,
//        iconResId = R.drawable.icon_machine
//    )
//
//    object Quotations : BottomNavigationItems(
//        route = LeafScreen.Quotations.route,
//        title = "Quotations",
//        icon = Icons.Default.RequestQuote,
//        iconResId = R.drawable.icon_quotation
//    )
//
//    object Orders : BottomNavigationItems(
//        route = LeafScreen.Orders.route,
//        title = "Orders",
//        icon = Icons.Default.Inventory,
//        iconResId = R.drawable.icon_order_incoming
//    )
//
//    object Settings : BottomNavigationItems(
//        route = LeafScreen.Settings.route,
//        title = "Settings",
//        icon = Icons.Default.Settings,
//        iconResId = R.drawable.icon_settings
//    )
//}
