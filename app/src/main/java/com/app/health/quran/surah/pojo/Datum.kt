package com.app.health.quran.surah.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


class Datum: Serializable {
    @SerializedName("number")
    @Expose
    var number: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("englishName")
    @Expose
    var englishName: String? = null

    @SerializedName("englishNameTranslation")
    @Expose
    var englishNameTranslation: String? = null

    @SerializedName("numberOfAyahs")
    @Expose
    var numberOfAyahs: Int? = null

    @SerializedName("revelationType")
    @Expose
    var revelationType: String? = null

}