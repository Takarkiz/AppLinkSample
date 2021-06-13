package com.example.naviagtionintroapp.router

import android.content.Context
import android.net.Uri

class Router {

    companion object {
        private val routes: Array<Routable<*, *>> = arrayOf(
            DetailRouter.Companion
        )

        fun routeToLink(context: Context?, code: Int, data: Uri?) {
            routes.find { it.deepLinkCode?.contains(code) == true }?.startDeepLink(context, data)
        }
    }
}