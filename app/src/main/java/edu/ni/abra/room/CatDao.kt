package edu.ni.abra.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCat(catEntity:CatCacheEntity):Long

    @Query("SELECT * FROM Breeds")
    suspend fun getCats():List<CatCacheEntity>
}