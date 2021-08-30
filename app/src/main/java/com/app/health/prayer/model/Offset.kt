package com.app.health.prayer.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Offset {

    @SerializedName("Imsak")
    @Expose
    private var imsak: Int? = null

    @SerializedName("Fajr")
    @Expose
    private var fajr: Int? = null

    @SerializedName("Sunrise")
    @Expose
    private var sunrise: Int? = null

    @SerializedName("Dhuhr")
    @Expose
    private var dhuhr: Int? = null

    @SerializedName("Asr")
    @Expose
    private var asr: Int? = null

    @SerializedName("Maghrib")
    @Expose
    private var maghrib: Int? = null

    @SerializedName("Sunset")
    @Expose
    private var sunset: Int? = null

    @SerializedName("Isha")
    @Expose
    private var isha: Int? = null

    @SerializedName("Midnight")
    @Expose
    private var midnight: Int? = null

    fun getImsak(): Int? {
        return imsak
    }

    fun setImsak(imsak: Int?) {
        this.imsak = imsak
    }

    fun getFajr(): Int? {
        return fajr
    }

    fun setFajr(fajr: Int?) {
        this.fajr = fajr
    }

    fun getSunrise(): Int? {
        return sunrise
    }

    fun setSunrise(sunrise: Int?) {
        this.sunrise = sunrise
    }

    fun getDhuhr(): Int? {
        return dhuhr
    }

    fun setDhuhr(dhuhr: Int?) {
        this.dhuhr = dhuhr
    }

    fun getAsr(): Int? {
        return asr
    }

    fun setAsr(asr: Int?) {
        this.asr = asr
    }

    fun getMaghrib(): Int? {
        return maghrib
    }

    fun setMaghrib(maghrib: Int?) {
        this.maghrib = maghrib
    }

    fun getSunset(): Int? {
        return sunset
    }

    fun setSunset(sunset: Int?) {
        this.sunset = sunset
    }

    fun getIsha(): Int? {
        return isha
    }

    fun setIsha(isha: Int?) {
        this.isha = isha
    }

    fun getMidnight(): Int? {
        return midnight
    }

    fun setMidnight(midnight: Int?) {
        this.midnight = midnight
    }
}