package com.app.health.ui.calender.fragment.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Meta {
    @SerializedName("latitude")
    @Expose
    private var latitude: Double? = null

    @SerializedName("longitude")
    @Expose
    private var longitude: Double? = null

    @SerializedName("timezone")
    @Expose
    private var timezone: String? = null

    @SerializedName("method")
    @Expose
    private var method: Method? = null

    @SerializedName("latitudeAdjustmentMethod")
    @Expose
    private var latitudeAdjustmentMethod: String? = null

    @SerializedName("midnightMode")
    @Expose
    private var midnightMode: String? = null

    @SerializedName("school")
    @Expose
    private var school: String? = null

    @SerializedName("offset")
    @Expose
    private var offset: Offset? = null

    fun getLatitude(): Double? {
        return latitude
    }

    fun setLatitude(latitude: Double?) {
        this.latitude = latitude
    }

    fun getLongitude(): Double? {
        return longitude
    }

    fun setLongitude(longitude: Double?) {
        this.longitude = longitude
    }

    fun getTimezone(): String? {
        return timezone
    }

    fun setTimezone(timezone: String?) {
        this.timezone = timezone
    }

    fun getMethod(): Method? {
        return method
    }

    fun setMethod(method: Method?) {
        this.method = method
    }

    fun getLatitudeAdjustmentMethod(): String? {
        return latitudeAdjustmentMethod
    }

    fun setLatitudeAdjustmentMethod(latitudeAdjustmentMethod: String?) {
        this.latitudeAdjustmentMethod = latitudeAdjustmentMethod
    }

    fun getMidnightMode(): String? {
        return midnightMode
    }

    fun setMidnightMode(midnightMode: String?) {
        this.midnightMode = midnightMode
    }

    fun getSchool(): String? {
        return school
    }

    fun setSchool(school: String?) {
        this.school = school
    }

    fun getOffset(): Offset? {
        return offset
    }

    fun setOffset(offset: Offset?) {
        this.offset = offset
    }


}