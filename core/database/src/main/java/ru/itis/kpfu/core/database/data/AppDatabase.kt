package ru.itis.kpfu.core.database.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.itis.kpfu.core.database.data.dao.PokemonDao
import ru.itis.kpfu.core.database.data.entity.PokemonEntity

@Database(entities = [
    PokemonEntity::class,
], version = 1)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao

    companion object {
        private const val DATABASE_NAME = "app.db"
        private var db_instance: AppDatabase? = null

        fun getAppDatabaseInstance(context: Context): AppDatabase {

            if (db_instance == null) {
                db_instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, DATABASE_NAME
                )
                    .build()
            }
            return db_instance as AppDatabase
        }
    }
    
}
