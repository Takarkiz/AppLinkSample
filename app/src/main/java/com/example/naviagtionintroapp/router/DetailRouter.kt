package com.example.naviagtionintroapp.router

import android.content.Context
import android.net.Uri
import com.example.naviagtionintroapp.DetailActivity
import android.os.Parcelable
import android.widget.Toast
import kotlinx.android.parcel.Parcelize

class DetailRouter {

    companion object : Routable<DetailActivity, RouterData> {

        private const val KEY_DETAIL_ID = "cellId"

        override val route: Class<DetailActivity>
            get() = DetailActivity::class.java
        override val deepLinkCode: Array<Int>?
            get() = arrayOf(1)

        override fun startDeepLink(context: Context?, data: Uri?) {
            data?.getQueryParameter(KEY_DETAIL_ID)?.toIntOrNull()?.let {
                Toast.makeText(context, "Movie Detail deep link", Toast.LENGTH_SHORT).show()
                startActivity(context, RouterData(it))
            }
        }

    }

    @Parcelize
    data class RouterData(
        val detailId: Int?
    ) : Parcelable
}