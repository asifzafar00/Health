package com.app.health.ui.calender.fragment.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Timings {
    @SerializedName("Fajr")
    @Expose
    private var fajr: String? = null

    @SerializedName("Sunrise")
    @Expose
    private var sunrise: String? = null

    @SerializedName("Dhuhr")
    @Expose
    private var dhuhr: String? = null

    @SerializedName("Asr")
    @Expose
    private var asr: String? = null

    @SerializedName("Sunset")
    @Expose
    private var sunset: String? = null

    @SerializedName("Maghrib")
    @Expose
    private var maghrib: String? = null

    @SerializedName("Isha")
    @Expose
    private var isha: String? = null

    @SerializedName("Imsak")
    @Expose
    private var imsak: String? = null

    @SerializedName("Midnight")
    @Expose
    private var midnight: String? = null

    fun getFajr(): String? {
        return fajr
    }

    fun setFajr(fajr: String?) {
        this.fajr = fajr
    }

    fun getSunrise(): String? {
        return sunrise
    }

    fun setSunrise(sunrise: String?) {
        this.sunrise = sunrise
    }

    fun getDhuhr(): String? {
        return dhuhr
    }

    fun setDhuhr(dhuhr: String?) {
        this.dhuhr = dhuhr
    }

    fun getAsr(): String? {
        return asr
    }

    fun setAsr(asr: String?) {
        this.asr = asr
    }

    fun getSunset(): String? {
        return sunset
    }

    fun setSunset(sunset: String?) {
        this.sunset = sunset
    }

    fun getMaghrib(): String? {
        return maghrib
    }

    fun setMaghrib(maghrib: String?) {
        this.maghrib = maghrib
    }

    fun getIsha(): String? {
        return isha
    }

    fun setIsha(isha: String?) {
        this.isha = isha
    }

    fun getImsak(): String? {
        return imsak
    }

    fun setImsak(imsak: String?) {
        this.imsak = imsak
    }

    fun getMidnight(): String? {
        return midnight
    }

    fun setMidnight(midnight: String?) {
        this.midnight = midnight
    }

}