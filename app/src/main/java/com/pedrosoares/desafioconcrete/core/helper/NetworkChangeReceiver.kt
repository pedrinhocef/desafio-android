package com.pedrosoares.desafioconcrete.core.helper

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.fragment.app.FragmentActivity

class NetworkChangeReceiver : BroadcastReceiver() {

    private var connectionChangeCallback: ConnectionChangeCallback? = null

    override fun onReceive(context: Context, intent: Intent) {

        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val isConnected = cm.activeNetworkInfo != null && cm.activeNetworkInfo.isConnected

        if (connectionChangeCallback != null) {
            connectionChangeCallback!!.onConnectionChange(isConnected)
        }
    }

    fun setConnectionChangeCallback(connectionChangeCallback: ConnectionChangeCallback) {
        this.connectionChangeCallback = connectionChangeCallback
    }

    interface ConnectionChangeCallback {
        fun onConnectionChange(isConnected: Boolean)
    }

    companion object {
        private const val CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE"
        fun FragmentActivity.networkChangeReceiver(connectionChangeCallback: ConnectionChangeCallback) {
            val intentFilter = IntentFilter(CONNECTIVITY_CHANGE)
            val networkChangeReceiver = NetworkChangeReceiver()
            this.registerReceiver(networkChangeReceiver, intentFilter)
            networkChangeReceiver.setConnectionChangeCallback(connectionChangeCallback)
        }

    }

}