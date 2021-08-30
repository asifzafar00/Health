package com.app.health.ui.calender.fragment.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Weekday_ {
    @SerializedName("en")
    @Expose
    private var en: String? = null

    @SerializedName("ar")
    @Expose
    private var ar: String? = null

    fun getEn(): String? {
        return en
    }

    fun setEn(en: String?) {
        this.en = en
    }

    fun getAr(): String? {
        return ar
    }

    fun setAr(ar: String?) {
        this.ar = ar
    }
}