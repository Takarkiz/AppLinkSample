package com.example.naviagtionintroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.naviagtionintroapp.router.DetailRouter
import com.example.naviagtionintroapp.router.Router

class MainActivity : AppCompatActivity() {

    companion object {
        private const val DEEP_LINK_FUNCTION_ID = "functionId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Toast.makeText(this, intent.data?.query, Toast.LENGTH_SHORT).show()
    }

    private fun route() {
        intent.data?.getQueryParameter(DEEP_LINK_FUNCTION_ID)?.toIntOrNull()?.let {
            Router.routeToLink(this, it, intent.data)
        } ?: run {
            DetailRouter.startActivity(
                this@MainActivity,
                DetailRouter.RouterData(-1)
            )
        }
        finish()
    }
}