package ru.itis.kpfu.core.network.data.response

import com.google.gson.annotations.SerializedName

/**
 * Класс [Ability], представляющий способность покемона.
 *
 * @property ability Информация о способности.
 * @property isHidden Флаг, указывающий, является ли способность скрытой.
 * @property slot Позиция способности.
 */
data class Ability(
    @SerializedName("ability")
    val ability: AbilityX?,
    @SerializedName("is_hidden")
    val isHidden: Boolean?,
    @SerializedName("slot")
    val slot: Int?
)

/**
 * Класс [AbilityX], представляющий информацию о способности покемона.
 *
 * @property name Имя способности.
 * @property url URL-адрес способности.
 */
data class AbilityX(
    @SerializedName("name")
    val name: String?,
    @SerializedName("url")
    val url: String?
)
