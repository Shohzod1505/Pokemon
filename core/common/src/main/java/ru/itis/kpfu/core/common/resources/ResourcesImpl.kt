package ru.itis.kpfu.core.common.resources

import android.app.Application
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import javax.inject.Inject

internal class ResourcesImpl @Inject constructor(
    private val application : Application
) : Resources {

    private val resources = application.resources

    override fun getString(@StringRes stringId: Int): String {
        return resources.getString(stringId)
    }

    override fun getDrawable(@DrawableRes resId: Int): Drawable? {
        return ContextCompat.getDrawable(application.applicationContext, resId)
    }

    override fun getColor(@ColorRes resId: Int): Int {
        return ContextCompat.getColor(application.applicationContext, resId)
    }

}
