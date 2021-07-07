package com.umbrella.data.util

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.NetworkInfo
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Checks if a network connection exists.
 */
@Singleton
class NetworkUtils @Inject constructor(@ApplicationContext val context: Context) {
    fun hasNetworkConnection(): Boolean {
        val connectivityManager =
            context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting
    }

    fun isConnected(): Boolean {
        val info = getNetworkInfo(context)
        return info != null && info.isConnected
    }

    private fun getNetworkInfo(context: Context?): NetworkInfo? {
        return if (context == null) null else try {
            val cm = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            cm.activeNetworkInfo
        } catch (e: Exception) {
            // we got SecurityException several times on Fabric: Neither user xxxxx nor current process has android
            // .permission.ACCESS_NETWORK_STATE
            null
        }
    }
}
