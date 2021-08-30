package com.app.health.quran.surah.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


class DuasBeans(
    var number: Int? = null,
    var name: String? = null,
    var englishName: String? = null,
    var englishNameTranslation: String? = null,
    var numberOfAyahs: Int? = null,
    var revelationType: String? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(number)
        parcel.writeString(name)
        parcel.writeString(englishName)
        parcel.writeString(englishNameTranslation)
        parcel.writeValue(numberOfAyahs)
        parcel.writeString(revelationType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DuasBeans> {
        override fun createFromParcel(parcel: Parcel): DuasBeans {
            return DuasBeans(parcel)
        }

        override fun newArray(size: Int): Array<DuasBeans?> {
            return arrayOfNulls(size)
        }
    }

}