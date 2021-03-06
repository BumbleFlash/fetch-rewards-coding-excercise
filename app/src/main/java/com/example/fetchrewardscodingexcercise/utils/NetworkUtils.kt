package com.example.fetchrewardscodingexcercise.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object NetworkUtils {

    @JvmStatic
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            activeNetworkInfo != null && activeNetworkInfo.isConnected
        } else {
            val networkCapabilities = connectivityManager.getNetworkCapabilities(
                    connectivityManager.activeNetwork)
            if (networkCapabilities != null) {
                networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) or
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) or
                        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
            } else {
                false
            }
        }
    }
}