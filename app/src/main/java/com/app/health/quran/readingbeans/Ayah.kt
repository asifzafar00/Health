package com.app.health.quran.readingbeans

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Ayah {
    @SerializedName("number")
    @Expose
    private var number: Int? = null

    @SerializedName("text")
    @Expose
    private var text: String? = null

    @SerializedName("numberInSurah")
    @Expose
    private var numberInSurah: Int? = null

    @SerializedName("juz")
    @Expose
    private var juz: Int? = null

    @SerializedName("manzil")
    @Expose
    private var manzil: Int? = null

    @SerializedName("page")
    @Expose
    private var page: Int? = null

    @SerializedName("ruku")
    @Expose
    private var ruku: Int? = null

    @SerializedName("hizbQuarter")
    @Expose
    private var hizbQuarter: Int? = null

    @SerializedName("sajda")
    @Expose
    private var sajda: Boolean? = null

    fun getNumber(): Int? {
        return number
    }

    fun setNumber(number: Int?) {
        this.number = number
    }

    fun getText(): String? {
        return text
    }

    fun setText(text: String?) {
        this.text = text
    }

    fun getNumberInSurah(): Int? {
        return numberInSurah
    }

    fun setNumberInSurah(numberInSurah: Int?) {
        this.numberInSurah = numberInSurah
    }

    fun getJuz(): Int? {
        return juz
    }

    fun setJuz(juz: Int?) {
        this.juz = juz
    }

    fun getManzil(): Int? {
        return manzil
    }

    fun setManzil(manzil: Int?) {
        this.manzil = manzil
    }

    fun getPage(): Int? {
        return page
    }

    fun setPage(page: Int?) {
        this.page = page
    }

    fun getRuku(): Int? {
        return ruku
    }

    fun setRuku(ruku: Int?) {
        this.ruku = ruku
    }

    fun getHizbQuarter(): Int? {
        return hizbQuarter
    }

    fun setHizbQuarter(hizbQuarter: Int?) {
        this.hizbQuarter = hizbQuarter
    }

    fun getSajda(): Boolean? {
        return sajda
    }

    fun setSajda(sajda: Boolean?) {
        this.sajda = sajda
    }

}