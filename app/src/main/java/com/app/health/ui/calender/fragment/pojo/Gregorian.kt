package com.app.health.ui.calender.fragment.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Gregorian {

    @SerializedName("date")
    @Expose
    private var date: String? = null

    @SerializedName("format")
    @Expose
    private var format: String? = null

    @SerializedName("day")
    @Expose
    private var day: String? = null

    @SerializedName("weekday")
    @Expose
    private var weekday: Weekday? = null

    @SerializedName("month")
    @Expose
    private var month: Month? = null

    @SerializedName("year")
    @Expose
    private var year: String? = null

    @SerializedName("designation")
    @Expose
    private var designation: Designation? = null

    fun getDate(): String? {
        return date
    }

    fun setDate(date: String?) {
        this.date = date
    }

    fun getFormat(): String? {
        return format
    }

    fun setFormat(format: String?) {
        this.format = format
    }

    fun getDay(): String? {
        return day
    }

    fun setDay(day: String?) {
        this.day = day
    }

    fun getWeekday(): Weekday? {
        return weekday
    }

    fun setWeekday(weekday: Weekday?) {
        this.weekday = weekday
    }

    fun getMonth(): Month? {
        return month
    }

    fun setMonth(month: Month?) {
        this.month = month
    }

    fun getYear(): String? {
        return year
    }

    fun setYear(year: String?) {
        this.year = year
    }

    fun getDesignation(): Designation? {
        return designation
    }

    fun setDesignation(designation: Designation?) {
        this.designation = designation
    }


}