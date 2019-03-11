package br.com.mdev.android.extension

import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.support.annotation.RequiresPermission

/**
 * Verifica se existe conexão com a internet
 */
@RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.isNetworkAvailable(): Boolean {
    return try {
        val manager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = manager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    } catch (tr: Throwable) {
        false
    }
}

/**
 * Verifica se o app está sendo executado em segundo plano
 */
fun Context.isAppOnForeground(): Boolean {
    val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
    val appProcesses = activityManager.runningAppProcesses ?: return false
    val packageName = packageName
    return appProcesses.any { it.importance == IMPORTANCE_FOREGROUND && it.processName == packageName }
}