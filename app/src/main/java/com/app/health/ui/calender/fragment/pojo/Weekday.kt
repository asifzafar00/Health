package com.app.health.ui.calender.fragment.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Weekday {


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