package ru.itis.kpfu.core.common.utils

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Расширение для класса [Fragment], позволяющее установить аргументы фрагмента.
 * Создает новый экземпляр [Bundle], применяет к нему переданный блок и устанавливает его в качестве аргументов фрагмента.
 * @param block Блок, который применяется к новому экземпляру [Bundle].
 * @return Экземпляр фрагмента с установленными аргументами.
 */
inline fun <T : Fragment> T.withArguments(block: Bundle.() -> Unit): T =
    apply { arguments = Bundle().apply(block) }
