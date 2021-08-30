package com.app.health.ui.calender.fragment.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Date {
    @SerializedName("readable")
    @Expose
    private var readable: String? = null

    @SerializedName("timestamp")
    @Expose
    private var timestamp: String? = null

    @SerializedName("gregorian")
    @Expose
    private var gregorian: Gregorian? = null

    @SerializedName("hijri")
    @Expose
    private var hijri: Hijri? = null

    fun getReadable(): String? {
        return readable
    }

    fun setReadable(readable: String?) {
        this.readable = readable
    }

    fun getTimestamp(): String? {
        return timestamp
    }

    fun setTimestamp(timestamp: String?) {
        this.timestamp = timestamp
    }

    fun getGregorian(): Gregorian? {
        return gregorian
    }

    fun setGregorian(gregorian: Gregorian?) {
        this.gregorian = gregorian
    }

    fun getHijri(): Hijri? {
        return hijri
    }

    fun setHijri(hijri: Hijri?) {
        this.hijri = hijri
    }


}