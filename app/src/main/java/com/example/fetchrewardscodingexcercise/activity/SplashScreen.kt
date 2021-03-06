package com.example.fetchrewardscodingexcercise.activity

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.fetchrewardscodingexcercise.R
import com.example.fetchrewardscodingexcercise.utils.NetworkUtils
import kotlin.system.exitProcess

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({
            if (NetworkUtils.isNetworkAvailable(applicationContext)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                AlertDialog.Builder(this@SplashScreen)
                        .setTitle(resources.getString(R.string.no_network))
                        .setMessage(resources.getString(R.string.no_network_summary))
                        .setPositiveButton(android.R.string.ok) { _: DialogInterface, _: Int ->
                            exitProcess(1)
                        }
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }, 3000)
    }
}