package ru.itis.kpfu.core.network.data.response

import com.google.gson.annotations.SerializedName

/**
 * Класс [Type], представляющий тип покемона.
 *
 * @property slot Слот, в котором находится тип покемона.
 * @property type Тип покемона.
 */
data class Type(
    @SerializedName("slot")
    val slot: Int?,
    @SerializedName("type")
    val type: TypeX?
)

/**
 * Класс [TypeX], представляющий конкретный тип покемона.
 *
 * @property name Название типа покемона.
 * @property url URL-адрес типа покемона.
 */
data class TypeX(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)
