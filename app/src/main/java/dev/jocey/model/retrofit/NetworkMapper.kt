package dev.jocey.model.retrofit

import dev.jocey.model.Track
import dev.jocey.model.retrofit.entityes.ApiItem
import dev.jocey.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor() : EntityMapper<ApiItem, Track> {

    override fun mapFromEntity(entity: ApiItem): Track {
        return Track(name = entity.name, hRef = entity.href, artists = entity.artists.toString())
    }

    override fun mapFromEntityList(items: List<ApiItem>): List<Track> {
        return items.map { mapFromEntity(it) }
    }

}