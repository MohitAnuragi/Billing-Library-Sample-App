package com.billing.billinglibrarysampleapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.billing.billinglibrarysampleapp.ui.theme.BillingLibrarySampleAppTheme
import com.billing.core.MonetizationKit
import com.billing.core.SdkConfig
import com.billing.ads.AdManager
import com.billing.ads.banner.compose.AdBanner
import com.billing.ads.banner.view.BannerType

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val config = SdkConfig(
            adMobAppId = "ca-app-pub-3940256099942544~3347511713",
            metaAppId = "YOUR_META_APP_ID",
            isDebug = true,
            autoInitialize = true
        )

        MonetizationKit.init(this, config)

        enableEdgeToEdge()
        setContent {
            BillingLibrarySampleAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MonetizationScreen(activity = this)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonetizationScreen(activity: ComponentActivity) {

    val context = activity

    // Test Ad IDs
    val BANNER_ID = "ca-app-pub-3940256099942544/6300978111"
    val INTERSTITIAL_ID = "ca-app-pub-3940256099942544/1033173712"
    val REWARDED_ID = "ca-app-pub-3940256099942544/5224354917"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Library Implementation", style = MaterialTheme.typography.headlineMedium)

        HorizontalDivider()

        Text("Banner Ad")
        AdBanner(
            modifier = Modifier.fillMaxWidth(),
            adUnitId = BANNER_ID,
            type = BannerType.ADMOB
        )

        HorizontalDivider()

        Button(onClick = {
            Toast.makeText(context, "Loading Interstitial...", Toast.LENGTH_SHORT).show()
            AdManager.loadInterstitial(context, INTERSTITIAL_ID, "")
        }) {
            Text("1. Load Interstitial")
        }

        Button(onClick = {
            AdManager.showInterstitial(activity) {
                Toast.makeText(context, "Interstitial Closed", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("2. Show Interstitial")
        }

        HorizontalDivider()

        Button(onClick = {
            Toast.makeText(context, "Loading Rewarded...", Toast.LENGTH_SHORT).show()
            AdManager.loadRewarded(context, REWARDED_ID, "")
        }) {
            Text("Load Rewarded Ad")
        }

        Button(onClick = {
            AdManager.showRewarded(
                activity = activity,
                onRewardEarned = {
                    Toast.makeText(context, "Congratulations! User Earned Reward!", Toast.LENGTH_LONG).show()
                },
                onAdClosed = {
                    Toast.makeText(context, "Rewarded Ad Closed", Toast.LENGTH_SHORT).show()
                }
            )
        }) {
            Text("Show Rewarded Ad")
        }
    }
}
