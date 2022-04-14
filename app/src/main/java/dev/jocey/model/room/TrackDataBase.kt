package dev.jocey.model.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TrackCacheEntity::class], version = 1)
abstract class TrackDataBase : RoomDatabase() {
    companion object {
        val DATABASE_NAME: String = "TRACK_DB"
    }

    abstract fun trackDao(): TrackDao
}