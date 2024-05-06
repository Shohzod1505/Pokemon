package ru.itis.kpfu.core.common.viewmodel

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Аннотация [ViewModelKey] используется для указания ключа в карте внедрения зависимостей для ViewModel.
 * Ключом является тип ViewModel, который предоставляется этой аннотацией.
 */
@MapKey
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewModelKey(val value: KClass<out ViewModel>)
