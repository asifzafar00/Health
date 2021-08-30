package com.app.health.prayer.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Params {


    @SerializedName("Fajr")
    @Expose
    private var fajr: Int? = null

    @SerializedName("Isha")
    @Expose
    private var isha: Int? = null

    fun getFajr(): Int? {
        return fajr
    }

    fun setFajr(fajr: Int?) {
        this.fajr = fajr
    }

    fun getIsha(): Int? {
        return isha
    }

    fun setIsha(isha: Int?) {
        this.isha = isha
    }

}