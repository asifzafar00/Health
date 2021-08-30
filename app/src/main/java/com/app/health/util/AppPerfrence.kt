package com.app.health.util

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


class AppPerfrence {
    private val PREF_NAME = "loc_pref"
    private val LAST_NETWORK_LOCATION_LAT = "lat"
    private val LAST_NETWORK_LOCATION_LOg = "log"
    private val LOCATION_ADDRESS = "address"


    fun saveLastLocAddress(mContext: Context, res: String) {
        var editor: SharedPreferences.Editor? = null
        try {
            val preferences: SharedPreferences =
                mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            editor = preferences.edit()
            editor.putString(LOCATION_ADDRESS, "" + res)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        editor!!.apply()
    }

    fun fetchLastLocAddress(mContext: Context): String? {
        val prefs: SharedPreferences =
            mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        return prefs.getString(LOCATION_ADDRESS, "0")
    }

    fun saveLastLocation(mContext: Context, lat: Double, log: Double) {
        var editor: SharedPreferences.Editor? = null
        try {
            val preferences: SharedPreferences =
                mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
            editor = preferences.edit()
            editor.putString(LAST_NETWORK_LOCATION_LAT, "" + lat)
            editor.putString(LAST_NETWORK_LOCATION_LOg, "" + log)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        editor!!.apply()
    }

    fun fetchLastLocation(mContext: Context): String? {
        val prefs: SharedPreferences =
            mContext.getSharedPreferences(PREF_NAME, MODE_PRIVATE)
        return prefs.getString(LAST_NETWORK_LOCATION_LAT, "0") + "," + prefs.getString(
            LAST_NETWORK_LOCATION_LOg,
            "0"
        )
    }
}