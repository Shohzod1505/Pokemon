package ru.itis.kpfu.core.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import ru.itis.kpfu.core.database.data.entity.PokemonEntity

@Dao
internal interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(pokemon: PokemonEntity)

}
