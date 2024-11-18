package com.example.android_2425_vc1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.Android2425vc1Theme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            Android2425vc1Theme {
                val windowSize = calculateWindowSizeClass(this)
                App(
                    windowSize = windowSize.widthSizeClass,
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AppCompactPreview() {
    Android2425vc1Theme {
        Surface {
            App(
                windowSize = WindowWidthSizeClass.Compact,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun AppMediumPreview() {
    Android2425vc1Theme {
        Surface {
            App(
                windowSize = WindowWidthSizeClass.Medium,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun AppExpandedPreview() {
    Android2425vc1Theme {
        Surface {
            App(
                windowSize = WindowWidthSizeClass.Expanded,
            )
        }
    }
}