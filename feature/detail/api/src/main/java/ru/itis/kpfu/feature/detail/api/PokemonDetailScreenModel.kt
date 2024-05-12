package ru.itis.kpfu.feature.detail.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Модель данных для [PokemonDetailScreen].
 * Реализует интерфейс Parcelable для возможности передачи между компонентами приложения.
 * @property name Имя покемона [PokemonDetailScreen].
 */
@Parcelize
data class PokemonDetailScreenModel(
    val name: String?,
) : Parcelable
