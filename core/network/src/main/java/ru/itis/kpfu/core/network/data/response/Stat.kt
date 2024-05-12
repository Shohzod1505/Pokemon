package ru.itis.kpfu.core.network.data.response

import com.google.gson.annotations.SerializedName

/**
 * Класс [Stat], представляющий характеристику покемона.
 *
 * @property baseStat Базовое значение характеристики.
 * @property effort Усилие, необходимое для увеличения характеристики.
 * @property stat Тип характеристики.
 */
data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int?,
    @SerializedName("effort")
    val effort: Int?,
    @SerializedName("stat")
    val stat: StatX?
)

/**
 * Класс [StatX], представляющий тип характеристики покемона.
 *
 * @property name Название характеристики.
 * @property url URL-адрес характеристики.
 */
data class StatX(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)
