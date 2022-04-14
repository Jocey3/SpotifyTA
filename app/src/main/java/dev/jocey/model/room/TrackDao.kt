package dev.jocey.model.room

import androidx.room.*

@Dao
interface TrackDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(trackCacheEntity: TrackCacheEntity): Long

    @Query("SELECT * FROM tracks")
    fun getAll(): List<TrackCacheEntity>

    @Query("SELECT * FROM tracks WHERE h_ref LIKE :hRef LIMIT 1")
    fun findByHRef(hRef: String): TrackCacheEntity

    @Delete
    fun delete(user: TrackCacheEntity)

}