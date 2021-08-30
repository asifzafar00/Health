package com.app.health.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast


class BootReceiver : BroadcastReceiver() {
    private val TAG: String? = BootReceiver::class.simpleName
    var alarm = Alarm()
    override fun onReceive(context: Context?, intent: Intent?) {

        Log.e(TAG, "bootreiever")
        Toast.makeText(context, "bootreiever", Toast.LENGTH_LONG).show()

        if (intent!!.action.equals(Intent.ACTION_BOOT_COMPLETED))
        {
            if (context != null) {
                alarm.setAlarm(context)
            };
        }
    }

}