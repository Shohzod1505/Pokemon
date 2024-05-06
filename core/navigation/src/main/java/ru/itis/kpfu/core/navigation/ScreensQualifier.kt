package ru.itis.kpfu.core.navigation

import javax.inject.Qualifier

/**
 * Аннотация [ScreensQualifier] используется для квалификации зависимостей, связанных с отображением экранов в приложении.
 * Она обеспечивает различение между разными типами зависимостей, связанными с экранами, при использовании Dagger.
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ScreensQualifier
