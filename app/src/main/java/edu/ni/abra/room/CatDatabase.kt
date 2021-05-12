package edu.ni.abra.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [CatCacheEntity::class], version = 4)
@TypeConverters(Converters::class)
abstract class CatDatabase:RoomDatabase() {
    companion object {
        val DATABASE_NAME = "CatBR"
    }
    abstract fun catDao():CatDao
}