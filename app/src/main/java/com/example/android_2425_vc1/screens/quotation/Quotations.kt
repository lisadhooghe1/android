package com.example.android_2425_vc1.screens.quotation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.Android2425vc1Theme

@Composable
fun Quotations(
    showDetail: () -> Unit
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Apply padding from Scaffold here
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = "Quotations Screen", style = MaterialTheme.typography.headlineMedium
            )
            Button(
                modifier = Modifier
                    .padding(top = 100.dp)
                    .align(Alignment.Center),
                onClick = { showDetail() }
            ) {
                Text(text = "Go to Quotations Detail")
            }
        }
    }
}

@Preview
@Composable
fun QuotationsScreenPreview() {
    Android2425vc1Theme() {
        Quotations(showDetail = {})
    }
}
