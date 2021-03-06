package com.example.fetchrewardscodingexcercise.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

/**
 * NetworkUtils has functions that interact with the ConnectivityManager libraries.
 */
object NetworkUtils {

    /**
     * Function to check if the network access is available
     * @param context Application context
     * @return Boolean if the network is active or not
     */
    @JvmStatic
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            activeNetworkInfo != null && activeNetworkInfo.isConnected
        } else {
            /*activeNetwork info and isConnected are not supported for API levels above 29. This
              work-around solves the problem.
              */
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