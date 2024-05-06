package ru.itis.kpfu.feature.detail.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Модель данных для [PokemonDetailScreen].
 * Реализует интерфейс Parcelable для возможности передачи между компонентами приложения.
 * @property id Уникальный идентификатор [PokemonDetailScreen].
 */
@Parcelize
data class PokemonDetailScreenModel(
    val id: Int
) : Parcelable
