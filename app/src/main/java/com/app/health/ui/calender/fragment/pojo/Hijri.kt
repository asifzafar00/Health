package com.app.health.ui.calender.fragment.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Hijri {
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
    private var weekday: Weekday_? = null

    @SerializedName("month")
    @Expose
    private var month: Month_? = null

    @SerializedName("year")
    @Expose
    private var year: String? = null

    @SerializedName("designation")
    @Expose
    private var designation: Designation_? = null

    @SerializedName("holidays")
    @Expose
    private var holidays: List<String?>? = null

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

    fun getWeekday(): Weekday_? {
        return weekday
    }

    fun setWeekday(weekday: Weekday_?) {
        this.weekday = weekday
    }

    fun getMonth(): Month_? {
        return month
    }

    fun setMonth(month: Month_?) {
        this.month = month
    }

    fun getYear(): String? {
        return year
    }

    fun setYear(year: String?) {
        this.year = year
    }

    fun getDesignation(): Designation_? {
        return designation
    }

    fun setDesignation(designation: Designation_?) {
        this.designation = designation
    }

    fun getHolidays(): List<String?>? {
        return holidays
    }

    fun setHolidays(holidays: List<String?>?) {
        this.holidays = holidays
    }


}