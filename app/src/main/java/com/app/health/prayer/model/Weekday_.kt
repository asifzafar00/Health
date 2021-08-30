package com.app.health.prayer.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Weekday_ {
    @SerializedName("en")
    @Expose
    private var en: String? = null

    fun getEn(): String? {
        return en
    }

    fun setEn(en: String?) {
        this.en = en
    }
}