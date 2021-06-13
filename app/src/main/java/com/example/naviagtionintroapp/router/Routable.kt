package com.example.naviagtionintroapp.router

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity

interface Routable<Route: AppCompatActivity, DATA: Parcelable> {

    companion object {
        const val ROUTE_DATA = "RouteData"
        const val DEEP_LINK_DATA = "DeepLinkData"
    }

    val route: Class<Route>

    val deepLinkCode: Array<Int>?

    fun startDeepLink(context: Context?, data: Uri?) {
        buildIntent(context).putExtra(ROUTE_DATA, data).also {
            context?.startActivity(it)
        }
    }

    fun startActivity(context: Context?, data: DATA?) {
        buildIntent(context).putExtra(ROUTE_DATA, data).also {
            context?.startActivity(it)
        }
    }

    fun buildIntent(context: Context?) = Intent(context, route)
}