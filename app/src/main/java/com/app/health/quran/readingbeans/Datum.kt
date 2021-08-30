package com.app.health.quran.readingbeans

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Datum {
    @SerializedName("number")
    @Expose
    private var number: Int? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("englishName")
    @Expose
    private var englishName: String? = null

    @SerializedName("englishNameTranslation")
    @Expose
    private var englishNameTranslation: String? = null

    @SerializedName("revelationType")
    @Expose
    private var revelationType: String? = null

    @SerializedName("numberOfAyahs")
    @Expose
    private var numberOfAyahs: Int? = null

    @SerializedName("ayahs")
    @Expose
    private var ayahs: List<Ayah?>? = null

    @SerializedName("edition")
    @Expose
    private var edition: Edition? = null

    fun getNumber(): Int? {
        return number
    }

    fun setNumber(number: Int?) {
        this.number = number
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getEnglishName(): String? {
        return englishName
    }

    fun setEnglishName(englishName: String?) {
        this.englishName = englishName
    }

    fun getEnglishNameTranslation(): String? {
        return englishNameTranslation
    }

    fun setEnglishNameTranslation(englishNameTranslation: String?) {
        this.englishNameTranslation = englishNameTranslation
    }

    fun getRevelationType(): String? {
        return revelationType
    }

    fun setRevelationType(revelationType: String?) {
        this.revelationType = revelationType
    }

    fun getNumberOfAyahs(): Int? {
        return numberOfAyahs
    }

    fun setNumberOfAyahs(numberOfAyahs: Int?) {
        this.numberOfAyahs = numberOfAyahs
    }

    fun getAyahs(): List<Ayah?>? {
        return ayahs
    }

    fun setAyahs(ayahs: List<Ayah?>?) {
        this.ayahs = ayahs
    }

    fun getEdition(): Edition? {
        return edition
    }

    fun setEdition(edition: Edition?) {
        this.edition = edition
    }
}