package com.app.health.ui.calender.fragment.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MonthBeans {

    @SerializedName("code")
    @Expose
    private var code: Int? = null

    @SerializedName("status")
    @Expose
    private var status: String? = null

    @SerializedName("data")
    @Expose
    private var data: List<Datum?>? =
        null

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

    fun getData(): List<Datum?>? {
        return data
    }

    fun setData(data: List<Datum?>?) {
        this.data = data
    }


}