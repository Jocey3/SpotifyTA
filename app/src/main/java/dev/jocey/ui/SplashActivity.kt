package dev.jocey.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import dev.jocey.R
import dev.jocey.util.Constants
import dev.jocey.util.Constants.Companion.CLIENT_ID
import dev.jocey.util.Constants.Companion.REDIRECT_URI


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        authenticateSpotify()
    }

    private fun authenticateSpotify() {
        val builder =
            AuthorizationRequest.Builder(CLIENT_ID, AuthorizationResponse.Type.TOKEN, REDIRECT_URI)
        builder.setScopes(arrayOf("streaming"))
        val request = builder.build()
        AuthorizationClient.openLoginActivity(this, 1337, request)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1337) {
            val response = AuthorizationClient.getResponse(resultCode, intent)
            when (response.type) {
                AuthorizationResponse.Type.TOKEN -> {
                    Constants.AUTH_TOKEN = response.accessToken
                    Log.d("myLog", "Token is got")
                }
                AuthorizationResponse.Type.ERROR -> {
                    Log.d("myLog", "Token is failed")
                }
                else -> {
                    Log.d("myLog", "Token is failed")
                }
            }
        }
    }

}