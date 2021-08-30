package com.app.health.prayer.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Designation_ {
    @SerializedName("abbreviated")
    @Expose
    private var abbreviated: String? = null

    @SerializedName("expanded")
    @Expose
    private var expanded: String? = null

    fun getAbbreviated(): String? {
        return abbreviated
    }

    fun setAbbreviated(abbreviated: String?) {
        this.abbreviated = abbreviated
    }

    fun getExpanded(): String? {
        return expanded
    }

    fun setExpanded(expanded: String?) {
        this.expanded = expanded
    }
}