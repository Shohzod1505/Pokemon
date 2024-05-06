package ru.itis.kpfu.core.database.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Класс [PokemonEntity] представляет сущность (Entity) базы данных для таблицы "pokemon".
 * @param name Уникальное имя предложения, являющееся первичным ключом.
 */
@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey val name: String,
)
