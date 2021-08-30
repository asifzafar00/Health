package com.app.health.prayer.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class PrayerModel {
    @SerializedName("code")
    @Expose
    private var code: Int? = null

    @SerializedName("status")
    @Expose
    private var status: String? = null

    @SerializedName("data")
    @Expose
    private var data: Data? = null

    fun getCode(): Int? {
        return code
    }

    fun setCode(code: Int?) {
        this.code = code
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getData(): Data? {
        return data
    }

    fun setData(data: Data?) {
        this.data = data
    }
}