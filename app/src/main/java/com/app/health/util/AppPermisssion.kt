package com.app.health.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class AppPermisssion {

    companion object {

        val PermissionRequest = 45
        val Request_permission_of_external_stoarge = 12
        val Request_permission_of_location = 1

    }

    fun callListOfPermission(): Array<String?>? {
        return arrayOf(
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }

    fun callListOfPermissionOfLocation(): Array<String?>? {
        return arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }

    fun callListOfPermissionOfExtStorage(): Array<String?>? {
        return arrayOf(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }


    fun checkListOfPermissions(
        ctx: Context,
        mList: Array<String?>?,
        requestCode: Int
    ): Boolean {
        var result: Int
        val listPermissionsNeeded: MutableList<String> = ArrayList()
        for (p in mList!!) {
            result = ContextCompat.checkSelfPermission(ctx, p!!)
            if (result != PackageManager.PERMISSION_GRANTED) {
                if (p != null) {
                    listPermissionsNeeded.add(p)
                }
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(
                (ctx as Activity?)!!,
                listPermissionsNeeded.toTypedArray(),
                requestCode
            )
            return false
        }
        return true
    }


    fun checkPermissionsWithOutDialog(
        ctx: Context?,
        mList: Array<String>,
        requestCode: Int
    ): Boolean {
        var result: Int
        val listPermissionsNeeded: MutableList<String> = ArrayList()
        for (p in mList) {
            result = ContextCompat.checkSelfPermission(ctx!!, p)
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p)
            }
        }
        return listPermissionsNeeded.isEmpty()
    }
}