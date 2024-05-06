package ru.itis.kpfu.core.common.resources

import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Интерфейс [Resources] определяет методы для доступа к ресурсам приложения, таким как строки, изображения и цвета.
 */
interface Resources {

    /**
     * Получает строку из ресурсов по ее идентификатору.
     * @param stringId Идентификатор строки.
     * @return Строка из ресурсов.
     */
    fun getString(@StringRes stringId: Int): String

    /**
     * Получает изображение из ресурсов по его идентификатору.
     * @param resId Идентификатор изображения.
     * @return Изображение из ресурсов, или null, если изображение не найдено.
     */
    fun getDrawable(@DrawableRes resId: Int): Drawable?

    /**
     * Получает цвет из ресурсов по его идентификатору.
     * @param resId Идентификатор цвета.
     * @return Цвет из ресурсов.
     */
    fun getColor(@ColorRes resId: Int): Int

}
