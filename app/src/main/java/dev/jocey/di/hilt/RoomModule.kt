package dev.jocey.di.hilt

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.jocey.model.room.TrackDao
import dev.jocey.model.room.TrackDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideTrackDb(@ApplicationContext context: Context): TrackDataBase {
        return Room.databaseBuilder(
            context,
            TrackDataBase::class.java,
            TrackDataBase.DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideTrackDao(trackDataBase: TrackDataBase): TrackDao {
        return trackDataBase.trackDao()
    }
}