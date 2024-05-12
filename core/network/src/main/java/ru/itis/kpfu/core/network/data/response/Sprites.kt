package ru.itis.kpfu.core.network.data.response

import com.google.gson.annotations.SerializedName

/**
 * Класс [Sprites], представляющий изображения покемона.
 *
 * @property backDefault URL-адрес изображения покемона сзади.
 * @property frontDefault URL-адрес изображения покемона спереди.
 */
data class Sprites(
    @SerializedName("back_default")
    val backDefault: String?,
    @SerializedName("front_default")
    val frontDefault: String?,
)
