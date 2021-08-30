package com.app.health


import android.content.pm.PackageManager
import android.location.Location
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.app.health.location.MyLocation
import com.app.health.mainfirst.MainFirstFragment
import com.app.health.more.MoreFragment
import com.app.health.prayer.AppPrayer
import com.app.health.qibla.QiblaFragment
import com.app.health.quran.QuranFragment
import com.app.health.util.AppPerfrence
import com.app.health.util.AppPermisssion
import com.app.health.util.AppPermisssion.Companion.Request_permission_of_location
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    var bottomNavigation: BottomNavigationView? = null
    var loc: Location? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottom_navigation)

        bottomNavigation!!.setOnNavigationItemSelectedListener(this)


        if (AppPermisssion().checkListOfPermissions(
                this,
                AppPermisssion().callListOfPermissionOfLocation(),
                Request_permission_of_location
            )
        ) {
            location()

        } else {
            Log.e("pers", "nit gran")
        }

        openFragment(MainFirstFragment())

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            Request_permission_of_location -> {

                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                    Log.e("asd", "PERMISSION_GRANTED")
                    location()
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(permissions[Request_permission_of_location])) {
                        } else {
                        }
                    }
                } else {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Log.e("asd", "nooonnonon")

                    }
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }
        }

    }

    private fun location() {
        // to Find the Location
        var locationName: String
        // to Find the Location
        val locationResult: MyLocation.LocationResult = object : MyLocation.LocationResult() {
            override fun gotLocation(location: Location?) {
                loc = location

                AppPerfrence().saveLastLocation(this@MainActivity, loc!!.latitude, loc!!.longitude)
                locationName = MyLocation().getAddress(loc, this@MainActivity)
                AppPerfrence().saveLastLocAddress(
                    this@MainActivity, locationName
                )
            }
        }

        val myLocation = MyLocation()
        myLocation.getLocation(this, locationResult)

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun openFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_today -> {
                openFragment(MainFirstFragment.newInstance("MainFirstFragment"))
                return true

            }
            R.id.nav_prayer -> {
                openFragment(AppPrayer.newInstance("AppPrayer"))
                return true

            }
            R.id.nav_quran -> {
                openFragment(QuranFragment.newInstance("QuranFragment"))
                return true

            }
            R.id.nav_qibla -> {
                openFragment(QiblaFragment.newInstance("QiblaFragment"))
                return true

            }
            R.id.nav_more -> {
                openFragment(MoreFragment.newInstance("MoreFragment"))
                return true

            }
        }
        return false
    }
}

