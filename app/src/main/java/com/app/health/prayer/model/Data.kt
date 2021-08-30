package com.app.health.prayer.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("timings")
    @Expose
    private var timings: Timings? = null

    @SerializedName("date")
    @Expose
    private var date: Date? = null

    @SerializedName("meta")
    @Expose
    private var meta: Meta? = null

    fun getTimings(): Timings? {
        return timings
    }

    fun setTimings(timings: Timings?) {
        this.timings = timings
    }

    fun getDate(): Date? {
        return date
    }

    fun setDate(date: Date?) {
        this.date = date
    }

    fun getMeta(): Meta? {
        return meta
    }

    fun setMeta(meta: Meta?) {
        this.meta = meta
    }
}