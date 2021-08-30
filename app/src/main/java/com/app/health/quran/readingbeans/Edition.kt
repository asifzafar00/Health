package com.app.health.quran.readingbeans

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class Edition {
    @SerializedName("identifier")
    @Expose
    private var identifier: String? = null

    @SerializedName("language")
    @Expose
    private var language: String? = null

    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("englishName")
    @Expose
    private var englishName: String? = null

    @SerializedName("format")
    @Expose
    private var format: String? = null

    @SerializedName("type")
    @Expose
    private var type: String? = null

    @SerializedName("direction")
    @Expose
    private var direction: String? = null

    fun getIdentifier(): String? {
        return identifier
    }

    fun setIdentifier(identifier: String?) {
        this.identifier = identifier
    }

    fun getLanguage(): String? {
        return language
    }

    fun setLanguage(language: String?) {
        this.language = language
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

    fun getFormat(): String? {
        return format
    }

    fun setFormat(format: String?) {
        this.format = format
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String?) {
        this.type = type
    }

    fun getDirection(): String? {
        return direction
    }

    fun setDirection(direction: String?) {
        this.direction = direction
    }

}