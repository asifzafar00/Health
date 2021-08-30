package com.app.health.quran.readingbeans


import android.os.Parcel
import android.os.Parcelable

class ReadingBean(var number: Int ?=null, var name: String?=null, var englishName: String?=null): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(number)
        parcel.writeString(name)
        parcel.writeString(englishName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ReadingBean> {
        override fun createFromParcel(parcel: Parcel): ReadingBean {
            return ReadingBean(parcel)
        }

        override fun newArray(size: Int): Array<ReadingBean?> {
            return arrayOfNulls(size)
        }
    }

}