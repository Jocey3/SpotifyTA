package dev.jocey.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tracks")
data class TrackCacheEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "h_ref")
    var hRef: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "artists")
    var artists: String

)
