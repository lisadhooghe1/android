//package com.example.android_2425_vc1.screens.dashboard
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.heightIn
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import com.example.android_2425_vc1.ui.components.BottomNavigationItems
//
//@Composable
//fun Dashboard(
//    navController: NavHostController = rememberNavController(),
//    modifier: Modifier = Modifier,
//) {
//    Scaffold(
//        bottomBar = {
//        },
//    ) { innerPadding ->
//        Column(
//            modifier = modifier
//                .padding(innerPadding)
//                .fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            TopLogoAndWelcome()
//
//            CenterContentTiles(
//                navController = navController,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .heightIn(min = 0.dp, max = 600.dp)
//                    .weight(1f)
//            )
//        }
//    }
//}
//
//@Composable
//fun TopLogoAndWelcome(salesman: String = "John Doe") {
//    Box(
//        Modifier
//            .background(MaterialTheme.colorScheme.primaryContainer)
//            .fillMaxWidth()
//            .padding(vertical = 20.dp),
//        contentAlignment = Alignment.Center
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally
//
//        ) {
//            Text(
//                text = "DOZER",
//                fontSize = 40.sp,
//                fontWeight = FontWeight.Bold,
//            )
//            Spacer(modifier = Modifier.height(4.dp))
//
//
//            Text(
//                // TODO get it from auth context
//                text = "Welkom, $salesman!",
//                fontSize = 16.sp,
//            )
//        }
//    }
//}
//
//
//@Composable
//fun CenterContentTiles(
//    navController: NavHostController,
//    modifier: Modifier = Modifier
//) {
//    Column(
//        modifier = modifier
//            .background(MaterialTheme.colorScheme.background)
//            .padding(vertical = 24.dp),
//        verticalArrangement = Arrangement.spacedBy(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        val items = listOf(
//            BottomNavigationItems.Machines,
//            BottomNavigationItems.Orders,
//            BottomNavigationItems.Quotations,
//            BottomNavigationItems.Settings
//        )
//
//        items.forEach { item ->
//            Row(
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.spacedBy(8.dp),
//                modifier = Modifier.padding(horizontal = 16.dp)
//            ) {
//                Icon(
//                    imageVector = item.icon!!,
//                    contentDescription = item.title,
//                    tint = Color.Black,
//                    modifier = Modifier.size(32.dp)
//                )
//                Button(
//                    onClick = { navController.navigate(item.route) },
//                    modifier = Modifier.fillMaxWidth(),
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Color.White,
//                        contentColor = Color.Black
//                    )
//                ) {
//                    Text(
//                        text = item.title!!,
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.SemiBold
//                    )
//                }
//            }
//        }
//    }
//}