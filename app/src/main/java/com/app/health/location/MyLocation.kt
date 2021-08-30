package com.app.health.location

import android.annotation.SuppressLint
import android.content.Context
import android.location.*
import android.os.Bundle
import android.util.Log
import java.util.*


class MyLocation {
    var timer1: Timer? = null
    var lm: LocationManager? = null
    var locationResult: LocationResult? = null
    var gps_enabled = false
    var network_enabled = false

    @SuppressLint("MissingPermission")
    fun getLocation(context: Context, result: LocationResult): Boolean {
        //I use LocationResult callback class to pass location value from MyLocation to user code.
        locationResult = result
        if (lm == null) lm = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager?

        //exceptions will be thrown if provider is not permitted.
        try {
            gps_enabled = lm!!.isProviderEnabled(LocationManager.GPS_PROVIDER)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        try {
            network_enabled = lm!!.isProviderEnabled(LocationManager.NETWORK_PROVIDER)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        //don't start listeners if no provider is enabled
        try {
            if (!gps_enabled && !network_enabled) return false
            if (gps_enabled) lm!!.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,
                0,
                0f,
                locationListenerGps
            )
            if (network_enabled) lm!!.requestLocationUpdates(
                LocationManager.NETWORK_PROVIDER,
                0,
                0f,
                locationListenerNetwork
            )
        } catch (e: Exception) {

        }
        timer1 = Timer()
        timer1!!.schedule(GetLastLocation(), 20000)
        return true
    }

    var locationListenerGps: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location?) {
            timer1!!.cancel()
            locationResult!!.gotLocation(location)


            //  lm.removeUpdates(this);
            //lm.removeUpdates(locationListenerNetwork);
        }

        override fun onProviderDisabled(provider: String) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onStatusChanged(
            provider: String,
            status: Int,
            extras: Bundle
        ) {
        }
    }

    var locationListenerNetwork: LocationListener = object : LocationListener {
        override fun onLocationChanged(location: Location?) {
            timer1!!.cancel()
            locationResult!!.gotLocation(location)
            // lm.removeUpdates(this);
            //   lm.removeUpdates(locationListenerGps);
        }

        override fun onProviderDisabled(provider: String) {}
        override fun onProviderEnabled(provider: String) {}
        override fun onStatusChanged(
            provider: String,
            status: Int,
            extras: Bundle
        ) {
        }
    }

    inner class GetLastLocation : TimerTask() {
        override fun run() {
            //lm.removeUpdates(locationListenerGps);
            //lm.removeUpdates(locationListenerNetwork);
            var net_loc: Location? = null
            var gps_loc: Location? = null

            try {
                if (gps_enabled) gps_loc = lm!!.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                if (network_enabled) net_loc =
                    lm!!.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

            } catch (e: SecurityException) {
                Log.e("exception", "" + e.message)
//                dialogGPS(this.getContext()) // lets the user know there is a problem with the gps
            }


            //if there are both values use the latest one
            if (gps_loc != null && net_loc != null) {
                if (gps_loc.getTime() > net_loc.getTime()) locationResult!!.gotLocation(gps_loc) else locationResult!!.gotLocation(
                    net_loc
                )
                return
            }
            if (gps_loc != null) {
                locationResult!!.gotLocation(gps_loc)
                return
            }
            if (net_loc != null) {
                locationResult!!.gotLocation(net_loc)
                return
            }
            locationResult!!.gotLocation(null)
        }
    }

    abstract class LocationResult {
        abstract fun gotLocation(location: Location?)
    }

    fun getAddress(latLng: Location? = null, ctx: Context): String {

        val geocoder = Geocoder(ctx, Locale.getDefault())
        val addresses: List<Address>?
        val address: Address?
        var addressText = ""

        addresses = geocoder.getFromLocation(latLng!!.latitude, latLng.longitude, 1)

        if (addresses.isNotEmpty()) {
            address = addresses[0]
            addressText = address.getAddressLine(0)
        } else {
            addressText = "its not appear"
        }
        return addressText
    }
}