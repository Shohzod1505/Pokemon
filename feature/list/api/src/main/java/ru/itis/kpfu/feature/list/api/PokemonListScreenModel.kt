package ru.itis.kpfu.feature.list.api

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Модель данных для [PokemonListScreen].
 * Реализует интерфейс Parcelable для возможности передачи между компонентами приложения.
 * @property id Уникальный идентификатор [PokemonListScreen].
 */
@Parcelize
data class PokemonListScreenModel(
    val id: Int
) : Parcelable
