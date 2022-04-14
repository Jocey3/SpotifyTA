package dev.jocey.model.room

import dev.jocey.model.Track
import dev.jocey.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor() : EntityMapper<TrackCacheEntity, Track> {
    override fun mapFromEntity(entity: TrackCacheEntity): Track {
        return Track(name = entity.name, hRef = entity.hRef, artists = entity.artists)
    }

    fun mapFromDomain(domain: Track): TrackCacheEntity {
        return TrackCacheEntity(hRef = domain.hRef, name = domain.name, artists = domain.artists)
    }

    override fun mapFromEntityList(entities: List<TrackCacheEntity>): List<Track> {
        return entities.map { mapFromEntity(it) }
    }
}