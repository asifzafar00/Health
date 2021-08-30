package com.app.health.ui.calender.fragment.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Month {

    @SerializedName("number")
    @Expose
    private var number: Int? = null

    @SerializedName("en")
    @Expose
    private var en: String? = null

    fun getNumber(): Int? {
        return number
    }

    fun setNumber(number: Int?) {
        this.number = number
    }

    fun getEn(): String? {
        return en
    }

    fun setEn(en: String?) {
        this.en = en
    }


}